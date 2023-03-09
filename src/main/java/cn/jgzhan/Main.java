package cn.jgzhan;

import cn.jgzhan.bo.DownFileBO;
import cn.jgzhan.service.FileDownService;

public class Main {



  private final static FileDownService fileDownService = new FileDownService();


  public static void main(String[] args) throws Exception {

//    var downFileBO = toFileDownBO(args);
    var downFileBO = toFileDownBO(new String[]{"https://dldir1.qq.com/weixin/mac/WeChatMac.dmg"});
//    var testUrl = "https://dldir1.qq.com/weixin/mac/WeChatMac.dmg";
    var allSuccess = fileDownService.downLoadFile(downFileBO);
    if (!allSuccess) {
      System.out.println("部分片段下载失败");
    }
  }

  private static DownFileBO toFileDownBO(String[] args) {
    var builder = DownFileBO.builder();
    builder.url(args[0]);
    if (args.length == 2){
      builder.targetLocalPath(args[1]);
    }
    return builder.build();
  }
}