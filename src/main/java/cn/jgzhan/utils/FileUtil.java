package cn.jgzhan.utils;


import static cn.jgzhan.constants.FileConstant.DEFAULT_FOLDER;

import cn.jgzhan.constants.FileConstant;

public class FileUtil {



  /**
   * 优先获取参数的地址，否则默认当前执行环境的文件夹
   * @param parFolder
   * @return
   */
  public static String getTargetFolder(String parFolder) {
    String targetLocalPath;
    if (parFolder == null || (targetLocalPath = parFolder.trim()) == "") {
      return DEFAULT_FOLDER;
    }
    if (!targetLocalPath.endsWith(FileConstant.FOLDER_SUFFIX)) {
      targetLocalPath += FileConstant.FOLDER_SUFFIX;
    }
    return targetLocalPath;
  }


  public static String getProgressBar(double processVla) {
    // 满格50格
    var processVlaInt = (int) processVla / 2;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 50; i++) {
      if (i < processVlaInt) {
        sb.append("◼");
      } else {
        sb.append("◻");
      }
    }
    return sb.toString();
  }


  /**
   * 打印进度
   */
  public static void printLog(int total, int progressSize) {
    var processVla = progressSize * 100.0 / total;
    var progressBar = getProgressBar(processVla);
    System.out.print("\r" + "下载进度 ：" + String.format("%.2f", processVla) + "%" + progressBar);
  }
}
