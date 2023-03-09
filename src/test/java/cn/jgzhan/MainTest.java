package cn.jgzhan;


import org.junit.Test;

/**
 * @author jgzhan
 * @version 1.0
 * @date 2023/3/9
 */
public class MainTest {


  @Test
  public void test() {
    try {
      Main.main(new String[]{"https://dldir1.qq.com/weixin/mac/WeChatMac.dmg"});
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {

    try {
      Main.main(new String[]{"https://dldir1.qq.com/weixin/mac/WeChatMac.dmg"});
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}