package yourendaiTest;

import common.util.CommonConstants;
import common.util.SecretUtils;

import java.util.Scanner;

/**
 * Created by zxz on 2015/2/1.
 */
public class TwiceEncode {

    public static void main(String[] args){


        Scanner scr = new Scanner(System.in);
        String stringMessage = scr.nextLine();
       String registerphoneEnc = SecretUtils.getTwiceEncString(stringMessage, CommonConstants.KEY_PHONE);
       //  String registerphoneEnc = SecretUtils.getTwiceEncString(stringMessage, CommonConstants.KEY_ID);

        System.out.println("加密后手机号码是："+registerphoneEnc);

    }
}
