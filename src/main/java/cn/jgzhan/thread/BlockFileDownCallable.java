package cn.jgzhan.thread;

import cn.jgzhan.bo.BlockInfo;
import cn.jgzhan.service.FileDownService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 * @author ZHAN jgZHAN
 * @create 2022-07-30 18:10
 */
//@Slf4j
public class BlockFileDownCallable implements Callable {

  private BlockInfo blockInfo;
  private File target;
  private String uri;

  public BlockFileDownCallable(BlockInfo blockInfo, File target, String uri) {
    this.blockInfo = blockInfo;
    this.target = target;
    this.uri = uri;
  }


  @Override
  public Object call() {
    //download and save data
    try {
      if (blockInfo.getFrom() >= blockInfo.getTo()) {
        return true;
      }
      InputStream inputStream = getInputStream();
      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
      RandomAccessFile randomAccessFile = getRandomAccessFile();
      byte[] buffer = new byte[1024 * 2];
      int readCount;

      while (true) {
        readCount = bufferedInputStream.read(buffer, 0, buffer.length);
        if (readCount < 0) {
          break;
        }
        blockInfo.setFrom(blockInfo.getFrom() + readCount);
        randomAccessFile.write(buffer, 0, readCount);
        FileDownService.progressSize.addAndGet(readCount);
      }

      randomAccessFile.close();
      bufferedInputStream.close();
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }


  private RandomAccessFile getRandomAccessFile() throws IOException {
    RandomAccessFile randomAccessFile = new RandomAccessFile(target, "rw");
    randomAccessFile.seek(blockInfo.getFrom());
    return randomAccessFile;
  }

  private InputStream getInputStream() throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(uri).openConnection();
    connection.setRequestProperty("Range",
        "bytes=" + blockInfo.getFrom() + "-" + blockInfo.getTo());
    connection.setRequestProperty("User-Agent",
        "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
    connection.connect();
    InputStream inputStream = connection.getInputStream();
    return inputStream;
  }
}