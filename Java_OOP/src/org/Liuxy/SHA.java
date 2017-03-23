package org.Liuxy;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，
 * 被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD通过碰撞法都被破解了， 但是SHA仍然是公认的安全加密算法，较之MD更为安全
 */

public class SHA {
	public static final String KEY_SHA = "SHA";

	public static String getResult(String inputStr) {
		BigInteger sha = null;
		System.out.println("=======加密前的数据:" + inputStr);
		byte[] inputData = inputStr.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
			messageDigest.update(inputData);
			sha = new BigInteger(messageDigest.digest());
			System.out.println("SHA加密后:" + sha.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha.toString();
	}

	public static void main(String args[]) {
		Encrypt en = new Encrypt();
		try {
			String inputStr = "简单加密";
			inputStr.equals(inputStr);
			System.out.println(en.SHA512(inputStr));
//			getResult(inputStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Encrypt
{

  /**
   * 传入文本内容，返回 SHA-256 串
   * 
   * @param strText
   * @return
   */
  public String SHA256(final String strText)
  {
    return SHA(strText, "SHA-256");
  }

  /**
   * 传入文本内容，返回 SHA-512 串
   * 
   * @param strText
   * @return
   */
  public String SHA512(final String strText)
  {
    return SHA(strText, "SHA-512");
  }

  /**
   * 字符串 SHA 加密
   * 
   * @param strSourceText
   * @return
   */
  private String SHA(final String strText, final String strType)
  {
    // 返回值
    String strResult = null;

    // 是否是有效字符串
    if (strText != null && strText.length() > 0)
    {
      try
      {
        // SHA 加密开始
        // 创建加密对象 并傳入加密類型
        MessageDigest messageDigest = MessageDigest.getInstance(strType);
        // 传入要加密的字符串
        messageDigest.update(strText.getBytes());
        // 得到 byte 類型结果
        byte byteBuffer[] = messageDigest.digest();

        // 將 byte 轉換爲 string
        StringBuffer strHexString = new StringBuffer();
        // 遍歷 byte buffer
        for (int i = 0; i < byteBuffer.length; i++)
        {
          String hex = Integer.toHexString(0xff & byteBuffer[i]);
          if (hex.length() == 1)
          {
            strHexString.append('0');
          }
          strHexString.append(hex);
        }
        // 得到返回結果
        strResult = strHexString.toString();
      }
      catch (NoSuchAlgorithmException e)
      {
        e.printStackTrace();
      }
    }

    return strResult;
  }
}
