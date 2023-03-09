package cn.jgzhan.bo;

import com.xiaoleilu.hutool.util.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownFileBO {

  /**
   * 下载地址
   */
  private String url;

  /**
   * 下载后存放本地的地址
   */
  private String targetLocalPath;

  /**
   * 文件总大小
   */
  private Integer totalSize;

  /**
   * 文件名
   */
  private String fileName;

  private List<BlockInfo> blockInfoList;

  public boolean isEmpty() {
    if (CollectionUtil.isEmpty(blockInfoList) || StrUtil.isEmpty(url)) {
      return true;
    }
    return false;
  }


}
