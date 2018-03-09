package common.util;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

public class CommonConstants {
  /**
   * 通知设置充值系列
   */
  public static String MESSAGE_CODE_CHONGZHI = "充值";
  public static String MESSAGE_CODE_CHONGZHI_XITONG = "chongzhi_xitong";
  public static String MESSAGE_CODE_CHONGZHI_DUANXIN = "chongzhi_duanxin";
  public static String MESSAGE_CODE_CHONGZHI_YOUJIAN = "chongzhi_youjian";
  /**
   * 通知设置提现系列
   */
  public static String MESSAGE_CODE_TIXIAN = "提现";
  public static String MESSAGE_CODE_TIXIAN_XITONG = "tixian_xitong";
  public static String MESSAGE_CODE_TIXIAN_DUANXIN = "tixian_duanxin";
  public static String MESSAGE_CODE_TIXIAN_YOUJIAN = "tixian_youjian";
  /**
   * 通知设置投标系列
   */
  public static String MESSAGE_CODE_TOUBIAO = "投标";
  public static String MESSAGE_CODE_TOUBIAO_XITONG = "toubiao_xitong";
  public static String MESSAGE_CODE_TOUBIAO_DUANXIN = "toubiao_duanxin";
  public static String MESSAGE_CODE_TOUBIAO_YOUJIAN = "toubiao_youjian";
  /**
   * 通知设置还款系列
   */
  public static String MESSAGE_CODE_HUANKUAN = "还款";
  public static String MESSAGE_CODE_HUANKUAN_XITONG = "huankuan_xitong";
  public static String MESSAGE_CODE_HUANKUAN_DUANXIN = "huankuan_duanxin";
  public static String MESSAGE_CODE_HUANKUAN_YOUJIAN = "huankuan_youjian";
  /**
   * 用来判断是什么类型
   */
  public static String USER_REGISTER_TYPE = "registerType";
  /**
   * 用来保存唯一标识
   */
  public static String USER_REGISTER_NUM = "registerNum";
  public static String BLANK = "";
  public static String NULL = null;
  /**
   * 返回信息的页面
   */
  public static String MSGPATH = "/msg.jsp";
  /**
   * 校验的msg
   */
  public static String VALIDATEMSG = "VALIDATEMSG";
  /**
   * 密码不需要重置
   */
  public static String USER_IS_RESET_PASS_YES = "1";
  /**
   * 密码需要重置
   */
  public static String USER_IS_RESET_PASS_NO = "0";

  /**
   * 用户组可以删
   */
  public static String GROUP_IS_DELETE_YES = "1";
  /**
   * 用户组不可删
   */
  public static String GROUP_IS_DELETE_NO = "0";

  /**
   * 有效
   */
  public static String IS_ENABLE_YES = "1";
  /**
   * 失效
   */
  public static String IS_ENABLE_NO = "0";
  /**
   * 状态 审核是够有效
   */
  public static String IS_ENABLE_AUDIT = "2";
  /**
   * 用户账户
   */
  public static String USER_ACCOUNT = "users_account";
  /**
   * 资金帐户
   */
  public static String MONEY_ACCOUNT = "funds_account";
  /**
   * 奖励账户
   */
  public static String REWARD_ACCOUNT = "reward_account";
  /**
   * 项目状态: 已完成
   */
  public static String PROJECT_STATUS_FINISHD = "finishd";
  /**
   * 项目状态：终审通过
   */
  public static String PROJECT_STATUS_FINAL_PASSED = "final_passed";
  /**
   * 项目状态：逾期
   */
  public static String PROJECT_STATUS_EXTENDED = "extended";

  /**
   * 还款计划状态：需还款
   */
  public static String PLAN_STATUS_REPYMENT = "repayment";

  /**
   * 还款计划状态：扣款成功
   */
  public static String PLAN_STATUS_CUTSUCCESS = "cutsuccess";
  /**
   * 还款计划状态：增加明细成功
   */
  public static String PLAN_STATUS_ADDDETAILSUCCESS = "adddetailsuccess";
  /**
   * 还款计划状态：执行还款成功
   */
  public static String PLAN_STATUS_APPLYSUCCESS = "applysuccess";

  /**
   * 还款计划状态：已还款
   */
  public static String PLAN_STATUS_REPAYMENTED = "repaymented";

  /**
   * 充值状态：等待支付
   */
  public static String RECHARGE_STATUS_WAIT = "等待支付";
  /**
   * 充值状态：支付成功
   */
  public static String RECHARGE_STATUS_COMPLETED = "支付成功";
  /**
   * 充值状态：支付失败
   */
  public static String RECHARGE_STATUS_CLOSED = "支付失败";
  /**
   * 充值状态：取消支付
   */
  public static String RECHARGE_STATUS_CANCEL = "取消支付";
  /**
   * 提现状态：失败;
   */
  public static String DRAWAL_STATUS_FAILED = "failed";
  /**
   * 提现状态：草稿;投资状态:草稿
   */
  public static String DRAWAL_STATUS_DRAFT = "draft";
  /**
   * 提现状态：取消;投资状态:取消
   */
  public static String DRAWAL_STATUS_CANCEL = "cancle";
  /**
   * 提现状态：提现已处理;投资状态:已处理
   */
  public static String DRAWAL_STATUS_PROCESSED = "processed";
  /**
   * 提现状态：退回
   */
  public static String DRAWAL_STATUS_BACKED = "backed";

  /**
   * 转账状态：草稿
   */
  public static String TRANSFER_STATUS_DRAFT = "draft";
  /**
   * 转账状态：处理中
   */
  public static String TRANSFER_STATUS_PROCESSING = "processing";
  /**
   * 转账状态：处理成功
   */
  public static String TRANSFER_STATUS_SUCCESS = "success";
  /**
   * 转账状态：处理失败
   */
  public static String TRANSFER_STATUS_FAIL = "fail";


  /**
   * 提现默认手续费
   */
  public static Double WITHDRAWAL_FEE = 0.0;// 0.0040;
  /**
   * 提现固定手续费2元
   */
  public static Double FIXED_FEE = 2.0;
  /**
   * 提现默认银行编码
   */
  public static String WITHDRAWAL_BANK_NO = "CCB";
  /**
   * 提现默认银行名称
   */
  public static String WITHDRAWAL_BANK_NAME = "中国建设银行——CCB(China Constuction Bank)";
  /**
   * 认证类型：实名认证
   */
  public static String AUTH_REAL_NAME = "auth_real_name";
  public static String AUTH_REAL_NAME_CN = "实名认证";
  /**
   * 实名认证：业务类型
   */
  public static String AUTH_REAL_FILE = "user_auth_file";
  public static String AUTH_REAL_IMG_POSITIVE = "positive";
  public static String AUTH_REAL_IMG_VERSA = "versa";
  /**
   * 认证类型：手机认证
   */
  public static String AUTH_TEL = "auth_tel";
  public static String AUTH_TEL_CN = "手机认证";
  /**
   * 认证类型：邮箱认证
   */
  public static String AUTH_EMAL = "auth_emal";
  public static String AUTH_EMAL_CN = "邮箱认证";
  /**
   * 验证类型：公共
   */
  public static String VERIFY_TYPE_COMMON = "common";
  /**
   * 验证类型：提现申请
   */
  public static String VERIFY_TYPE_WITHDRAWAL = "withdrawal";
  /**
   * 验证类型：手机认证
   */
  public static String VERIFY_TYPE_PHONE = "phone";
  /**
   * 验证类型：更换手机认证
   */
  public static String VERIFY_TYPE_PHONECHANGE = "phoneChange";
  /**
   * 验证类型：邮箱认证
   */
  public static String VERIFY_TYPE_EMAIL = "email";
  /**
   * 验证类型：邮箱更换认证
   */
  public static String VERIFY_TYPE_EMAILCHANGE = "emailChange";
  /**
   * 验证类型：找回支付密码手机认证
   */
  public static String VERIFY_TYPE_FINDPAYPWD = "findPayPwd";

  /**
   * 银行编码字符集
   */
  public static String BANKS_SETS = "banks_sets";
  /**
   * 顶级菜单的默认的父菜单的id
   */
  public static String MENU_PARENT_ID = "0";

  /**
   * 菜单链接方式_blank
   */
  public static String MENU_TARGET_BLANK = "_blank";

  /**
   * 菜单链接方式空
   */
  public static String MENU_TARGET_NULL = "";

  /**
   * session里的用户
   */
  public static String SESSION_USER = "sessionUser";

  /**
   * 默认用户
   */
  public static String DEFAULT_USERNAME = "test";


  /**
   * 用户密码key
   */
  public final static String KEY_PASSWORD = "Key:PassW0rd&login-yourendai";
  /**
   * 用户Idkey
   */
  public final static String KEY_USERID = "Key:UserIdlogin-yourendai";
  /**
   * 身份证key
   */
  public final static String KEY_ID = "KeyqazOkm&*)1092";

  /**
   * 支付密码key
   */
  public final static String KEY_PAY_PASSWORD = "payYuio%^&8921";


  /**
   * 手机key
   */
  public final static String KEY_PHONE = "phoneKeyHJkl-12%56-#pl,";


  /**
   * 注册码的key
   */
  public final static String KEY_REGISTERCODE = "registerCode5Key";

  /**
   * 银行账号key
   */
  public final static String KEY_BANK_PHONE = "bankKeyBvMn-0975-)^&2";

  /**
   * 约标密码key
   */
  public final static String KEY_PORMISE_PASSWORD = "qp[zo)1912pormise_password";


  /**
   * 后台用户组
   */
  public static String BACKEND_GROUP = "后台用户组";

  /**
   * 前台用户组
   */
  public static String FRONT_GROUP = "前台用户组";
  /**
   * 用户注册的短信验证码模板
   */
  public static String REGISTER_SMS_TEMPLATE = "尊敬的用户，您本次申请的短信验证码为：##，请您在30分钟内尽快使用。【有人贷】";


  /**
   * app提现的短信验证码模板
   */
  public static String WITHDRAW_SMS_TEMPLATE = "尊敬的用户，您本次短信验证码为：##，请在1分钟内按页面提示提交验证码。【有人贷】";
  /**
   * 管理费常量 vip
   */
  public static double INTEREST_MANAGE_MONEY_VIP = 0.08;

  /**
   * 管理费常量 no vip 促销活动 非会员管理费按 0.08收，活动结束后改回0.1
   */
  public static double INTEREST_MANAGE_MONEY_NOVIP = 0.08;


  /**
   * 是否启用投标是
   */
  public static String IS_AUTO_Y = "auto";

  /**
   * 是否启用投标否
   */
  public static String IS_AUTO_N = "unauto";

  /**
   * 用于vm系统引用
   */
  public static String META = "<!--#include virtual=\"/meta.html\" -->";
  /**
   * 用于vm系统引用
   */
  public static String HEAD_TOP = "<!--#include virtual=\"/index/head_top.html\" -->";
  /**
   * 用于vm系统引用
   */
  public static String HEAD_BOTTOM = "<!--#include virtual=\"/index/head_bottom.html\" -->";
  /**
   * 用于vm系统引用
   */
  public static String FOOTER = "<!--#include virtual=\"/footer.html\" -->";
  /**
   * 用于vm系统引用
   */
  public static String js = "<!--#include virtual=\"/front/js.html\" -->";
  /**
   * 用于vm系统引用 "<!--#include virtual=\"/front/implement_js.html\" -->"
   */
  public static String DSP_JS = "";

  public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

  public static DecimalFormat decimalFormat = new DecimalFormat();

  static {
    decimalFormat.setMaximumFractionDigits(2);
    decimalFormat.setGroupingSize(0);
    decimalFormat.setRoundingMode(RoundingMode.FLOOR);
  }

  public static DateFormat dfs = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

  /**
   * 获取word中最后一个table,现在只在POIUtil里使用
   */
  public static int LAST_TABLE = -1;


  /**
   * 手工投标
   */
  public static String INVESTTYPE_UNAUTO = "investtype_unauto";

  /**
   * 自动投标
   */
  public static String INVESTTYPE_AUTO = "investtype_auto";

  /**
   * 债券转让
   */
  public static String INVESTTYPE_CREDITE = "investtype_credite";
  /**
   * 债券转让管理费
   */
  public static Double CREDITE_MANAGE_FEE = 0.001;

  /**
   * 支付方式：汇付宝
   */
  public static String RECHARGE_TYPE_HEEAPY = "heeapy";
  /**
   * 支付方式：奖励发放
   */
  public static String RECHARGE_TYPE_REWARD = "reward";
  /**
   * 支付方式：金额迁移
   */
  public static String RECHARGE_TYPE_INIT = "init";
  /**
   * 支付方式：红包发放
   */
  public static String RECHARGE_TYPE_LUCK = "luck";
  /**
   * 支付方式：体验标还款
   */
  public static String RECHARGE_TYPE_EXPERIENCE = "experienceRepayment";

  /**
   * 返回的状态
   */
  public static String STATUS = "status";
  /**
   * 返回的状态,成功
   */
  public static String STATUS_SUCCESS = "success";

  /**
   * 返回的状态,失败
   */
  public static String STATUS_ERROR = "error";

  /**
   * 返回的信息
   */
  public static String MSG = "msg";

  /**
   * 系统管理员用户id
   */
  public static String SYS_USER_ID = "4028698144a638180144a6381a2a0001";

  /**
   * 系统管理员用户名称
   */
  public static String SYS_USER_NAME = "系统管理员";

  /**
   * 判断OBJ是否为空
   */
  public static boolean isEmpty(Object obj) {
    if (obj == null)
      return true;

    //如果为String类型
    if (obj instanceof String) {
      if ("null".equals(((String) obj).toLowerCase())) {
        return false;
      } else {
        return ((String) obj).trim().equals("");
      }
    } else if (obj instanceof Collection) {
      // 如果是collection
      Collection coll = (Collection) obj;
      return coll.size() == 0;
    } else if (obj instanceof Map) {
      // 如果是Map
      Map map = (Map) obj;
      return map.size() == 0;
    } else if (obj.getClass().isArray()) {
      // 如果是数组
      return Array.getLength(obj) == 0;
    } else {
      // 其他的话
      return false;
    }
  }

  /**
   * 奖励类型_红包
   */
  public static String REWARD_TYPE_LUCK_MONEY = "LUCK_MONEY";
  /**
   * 奖励类型_体验金
   */
  public static String REWARD_TYPE_EXPERIENCE_MONEY = "EXPERIENCE_MONEY";
  /**
   * 奖励类型_现金券
   */
  public static String REWARD_TYPE_CASH_COUPON = "CASH_COUPON";
  /**
   * 奖励类型_提现券
   */
  public static String REWARD_TYPE_CARRY_CASH = "CARRY_CASH";
  /**
   * 奖励类型_收益券
   */
  public static String REWARD_TYPE_EARNINGS_CASH = "EARNINGS_CASH";

  /**
   * 奖励使用范围 积分兑换
   */
  public static String ISSUE_EXCHANGE = "ISSUE_EXCHANGE";
  /**
   * 奖励使用范围 手动发放
   */
  public static String MANUAL_ISSUED = "MANUAL_ISSUED";

  /**
   * 奖励使用范围 自动发放
   */
  public static String AUTO_ISSUE = "AUTO_ISSUE";

}
