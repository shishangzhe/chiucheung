package cn.chiucheung.controller.utils;

import java.io.File;
import java.io.IOException;

//操作文件及文件夹的工具类
public class FileUtil {
  // 验证字符串是否为正确路径名的正则表达式
  private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
  // 通过path.matches(matches)方法的返回值判断是否正确
  // path为路径字符串
  static File file;
  static boolean flag = false;

  // 根据路径删除指定的目录或文件,无论存在与否
  public static boolean DeleteFolder(String deletePath) {
    flag = false;
    if (deletePath.matches(matches)) {
      file = new File(deletePath);
      // 判断目录或文件是否存在
      if (!file.exists()) {
        // 不存在返回false
        return flag;
      } else {
        // 判断是否为文件
        if (file.isFile()) {
          // 为文件时调用删除文件方法
          return deleteFile(deletePath);
        } else {
          // 为目录时调用删除目录方法
          return deleteDirectory(deletePath);
        }

      }

    } else {
      System.out.println("请传人正确路径!");
      return false;
    }
  }

  // 删除单个文件
  public static boolean deleteFile(String filePath) {
    flag = false;
    file = new File(filePath);
    // 路径为文件且不为空则进行删除
    if (file.isFile() && file.exists()) {
      // 文件删除
      file.delete();
      flag = true;
    }
    return flag;
  }

  // 删除目录（文件夹）以及目录下的文件
  public static boolean deleteDirectory(String dirPath) {
    // 如果path不以文件分隔符结尾，自动添加文件分隔符
    if (!dirPath.endsWith(File.separator)) {
      dirPath = dirPath + File.separator;
    }
    File dirFile = new File(dirPath);
    // 如果dir对应的文件不存在，或者不是一个目录，则退出
    if (!dirFile.exists() || !dirFile.isDirectory()) {
      return false;
    }
    flag = true;
    // 获得传入路径下的所有文件
    File[] files = dirFile.listFiles();
    // 循环遍历删除文件夹下的所有文件(包括子目录)
    for (int i = 0; i < files.length; i++) {
      // 删除子文件
      if (files[i].isFile()) {
        flag = deleteFile(files[i].getAbsolutePath());
        System.out.println(files[i].getAbsolutePath() + " 删除成功");
        if (!flag)
          break;// 如果删除失败，则跳出
      } else {
        // 运用递归，删除子目录
        flag = deleteDirectory(files[i].getAbsolutePath());
        if (!flag)
          break;// 如果删除失败，则跳出
      }
    }
    if (!flag)
      return false;
    if (dirFile.delete()) {
      // 删除当前目录
      return true;
    } else {
      return false;
    }
  }

  // 创建单个文件
  public static boolean createFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      // 判断文件是否存在
      System.out.println("目标文件已存在" + filePath);
      return false;
    }
    if (filePath.endsWith(File.separator)) {
      // 判断文件是否为目录
      System.out.println("目标文件不能为目录！");
      return false;
    }
    if (!file.getParentFile().exists()) {
      // 判断目标文件所在的目录是否存在
      // 如果目标文件所在的文件夹不存在，则创建父文件夹
      System.out.println("目标文件所在目录不存在，准备创建它！");
      if (!file.getParentFile().mkdirs()) {
        // 判断创建目录是否成功
        System.out.println("创建目标文件所在的目录失败！");
        return false;
      }
    }
    try {
      if (file.createNewFile()) {
        // 创建目标文件
        System.out.println("创建文件成功:" + filePath);
        return true;
      } else {
        System.out.println("创建文件失败！");
        return false;
      }
    } catch (IOException e) {
      // 捕获异常
      e.printStackTrace();
      System.out.println("创建文件失败！" + e.getMessage());
      return false;
    }
  }

  // 创建目录
  public static boolean createDir(String destDirName) {
    File dir = new File(destDirName);
    if (dir.exists()) {
      // 判断目录是否存在
      System.out.println("创建目录失败，目标目录已存在！");
      return false;
    }
    if (!destDirName.endsWith(File.separator)) {
      // 结尾是否以"/"结束
      destDirName = destDirName + File.separator;
    }
    if (dir.mkdirs()) {
      // 创建目标目录
      System.out.println("创建目录成功！" + destDirName);
      return true;
    } else {
      System.out.println("创建目录失败！");
      return false;
    }
  }

  // 创建临时文件
  public static String createTempFile(String prefix, String suffix,
      String dirName) {
    File tempFile = null;
    // 目录如果为空
    if (dirName == null) {

      try {
        // 在默认文件夹下创建临时文件
        tempFile = File.createTempFile(prefix, suffix);
        // 返回临时文件的路径
        return tempFile.getCanonicalPath();
      } catch (IOException e) {
        // 捕获异常
        e.printStackTrace();
        System.out.println("创建临时文件失败：" + e.getMessage());
        return null;
      }
    } else {
      // 指定目录存在
      // 创建目录
      File dir = new File(dirName);
      if (!dir.exists()) {
        // 如果目录不存在则创建目录
        if (FileUtil.createDir(dirName)) {
          System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
          return null;
        }
      }
      try {
        // 在指定目录下创建临时文件
        tempFile = File.createTempFile(prefix, suffix, dir);
        // 返回临时文件的路径
        return tempFile.getCanonicalPath();
      } catch (IOException e) {
        // 捕获异常
        e.printStackTrace();
        System.out.println("创建临时文件失败!" + e.getMessage());
        return null;
      }
    }
  }

}
