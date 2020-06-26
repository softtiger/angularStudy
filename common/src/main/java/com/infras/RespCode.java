package com.infras;

import java.util.IllegalFormatException;

public enum RespCode {
	
	SUCCESS(0, "成功", ""),

	FAIL(1, "失败", ""),
	
	ERROR(-1, "错误", ""),
	
	DB_ERROR(-10, "数据更新失败", ""),
	
	INVALID_DATA_PRIVILEGE(-20, "非法的数据访问", "非法的数据访问:%s"),
	
	REDIS_ERROR(-30, "缓存更新失败", "缓存更新失败"),
	
	MQ_ERROR(-40, "MQ失败", "MQ失败:%s"),
	
	ACCESS_TOO_FASTER(-50,"请求过于频繁","请求过于频繁"),
	
	PARAM_ERROR(3, "参数不符合要求", "参数不符合要求:%s属性为空或属性值不合法！"),
	
	
	PARAM_ERROR_RANGE(4, "参数不符合要求", "%s"),
	
	REDISK_LOCK_ERROR(5, "锁获取失败，业务不允许并发", "%s"),
	
	UN_UNIQUE_ERROR(6, "违反唯一约束", "违反唯一约束:%s必须唯一！"),
	
	QR_CODE_SWITCH_CLOSE(7, "二维码已关闭", "二维码已关闭"),
	
	QR_CODE_ERROR(8, "平台校验二维码校验错误", "平台校验:%s"),
	
	QR_BIND_EXIT_ERROR(9,"用户已经绑定二维码",""),
	
	QR_BIND_ERROR(10,"用户绑定二维码失败",""),
	
	QR_USER_NOT_BIND(11,"用户未绑定二维码","用户未绑定二维码"),
	
	QR_VALID_USER_BIND_ERROR(12,"用户绑定二维码和平台不一致","用户绑定二维码和平台不一致"),
	
	
	PARAM_CONTAIN_SPECIAL(400, "参数不符合要求", "%s不能包含特殊字符"),
	
	PLATFORM_INVALIDATE_ERROR(1000, "平台商不存在或未开启", ""),
	
	USER_NO_LOGIN(1006, "未登录或登录已超时，请重新登录", ""),
	
	
	USER_UNSUPPORT_SPCODE(1007, "DEMO 和PW厅不支持", "DEMO 和PW厅不支持"),
	
	USER_LOGIN_ACCOUNT_TYPE_ERROR(1010, "登录身份为空或不正确", ""),
	
	USER_LOGIN_NAME_ERROR(1011, "登录帐号不正确", ""),

	USER_LOGIN_PWD_ERROR(1012, "登录密码不正确", ""),	
	
	USER_NON_EXIST_ERROR(1013, "登录名或密码不正确", ""),	// 即用户不存在
	
	USER_ACCCOUNT_ERROR(1014,"用户账号不存在",""),
	
	INVITE_CODE_NOT_EXIST(1016, "验证码不正确", ""),
	
		
	USER_BLACKS_ERROR(1009, "您的账号存在异常，请与系统管理员联系", ""),
	
	USER_LOGIN_NAME_REPEAT(1018, "登录帐号重复", ""),

	SITE_DAILY_QUOTA_REGENERATE_TIME_ERROR(2000,"只允许重新生成当天和明天的座席限额数据",""),
	
	
	//充值订单金额调整相关，21XX
	ORDER_ADJUST_ORDER_NOT_EXIT(2100,"充值订单不存在，不允许冲正","充值订单不存在"),
	
	ORDER_ADJUST_BANK_NO_BALANCE(2101,"银商剩余授信额度小于调整额度，提交失败！",""),
	
	ORDER_ADJUST_LIMIT_ERROR(2102,"此订单冲正申请已达到最大次数，不允许冲正",""),
	
	ORDER_ADJUST_ORDER_UNFINISHER(2103,"订单未完成，不允许发起冲正申请",""),
	
	ORDER_ADJUST_ORDER_SUBMIT_ERROR(2104,"订单冲正，提交审核失败",""),
	
	ORDER_ADJUST_EMPTY(2105,"订单冲正申请不存在，提交失败",""),
	
	ORDER_ADJUST_AUDIT_STATUS_ERROR(2106,"订单冲正未提交，不允许审核",""),
	
	ORDER_ADJUST_AUDIT_ERROR(2107,"订单冲正审核失败，请联系管理员",""),
	
	ORDER_ADJUST_SUBMIT_REPEAT(2108,"系统检测重复提交，请稍后重试",""),
	
	ORDER_ADJUST_CHECK_REPEAT(2109,"订单冲正不允许重复审核",""),
	
	ORDER_ADJUST_UPDATE_ERROR(2110,"订单冲正已提交，不允许更新",""),
	
	ORDER_ADJUST_SITE_NO_BALANCE(2111,"座席剩余授信额度小于调整额度，提交失败！",""),
	
	ORDER_ADJUST_ORDER_AMOUNT_ERROR(2112,"总的扣减金额大于订单总金额！",""),
	
	ORDER_ADJUST_ADD_REPEAT(2113,"存在未完成的冲正申请，不允许发起新的申请！",""),
	
	ORDER_ADJUST_ADD_AMOUNT_ERROR(2114,"扣减金额不能超过订单金额！",""),
	
	ORDER_ADJUST_AMOUNT_OUT_SYSTEMCFG(2115,"订单冲正金额不能超过系统最大限制金额！","系统冲正最大限制金额:%s"),
	
	ORDER_ADJUST_RETRY_SUBMIT_STATUS_ERROR(2116,"订单冲正申请未提交，不允许重试",""),
	
	ORDER_ADJUST_RETRY_CHECK_STATUS_ERROR(2117,"订单冲正申请未审核，不允许重试",""),
	
	ORDER_ADJUST_RETRY_PROCESS_STATUS_ERROR(2118,"订单冲正申请不允许重试",""),
	
	ORDER_ADJUST_OLD_ORDER_FORBID(2119,"老订单（无playerId）不支持冲正申请",""),
	
	ORDER_ADJUST_ACCOUNT_ERROR(2120,"订单提交人和操作人不一致，不允许提交",""),
	
	
	//充值订单金额调整相关结束，21XX

	BUSINESS_LOGICA_ERROR(8000, "业务逻辑错误：", "业务逻辑错误:%s"),
	
	PERMISSION_ERROR(3000, "越权访问：", "越权访问:%s"),
	
	/**平台商相关定义**/
	PLATFORM_SERCRET_KEY_UPDATE_ERROR(4000,"平台商秘钥更新失败","平台商秘钥更新失败"),
	
	PLATFORM_SERCRET_KEY_EXIT(4001,"平台商秘钥已存在","平台商秘钥已存在"),
	
	PLATFORM_ILLEGAL(4002,"平台商不合法","平台商不合法"),
	
	
	
	/** 座席相关定义 **/
	SITE_OVER_QUOTA(8100,"座席当日额度用完,联系银商重新上分","座席当日额度用完,联系银商重新上分"),
	
	SITE_UDPATE_ERROR(8101,"更新座席信息失败",""),
	
	SELECT_SITE_ERROR(8102, "选择座席失败,无有效座席", "选择座席失败,无有效座席"),
	SELECT_SITE_STATUS_ERROR(81020, "选择座席失败，座席状态不可用", "选择座席失败，座席状态不可用"),
	SELECT_SITE_STOP_ORDER_ERROR(81021, "选择座席失败，座席暂停接单", "选择座席失败，座席暂停接单"),
	SELECT_SITE_BANK_STATUS_ERROR(81022, "选择座席失败，所属银商状态不可用", "选择座席失败，所属银商状态不可用"),
	SELECT_SITE_BANK_NO_AVALIABLE_QUOTA_ERROR(81023, "选择座席失败，所属银商无可用额度", "选择座席失败，所属银商无可用额度"),
	SELECT_SITE_NO_AVALIABLE_QUOTA_ERROR(81024, "选择座席失败，座席无可用额度", "选择座席失败，座席无可用额度"),
	SELECT_SITE_SPINFO_EMPTY(81025, "选择座席失败，厅信息不存在", "选择座席失败，厅信息不存在"),
	SELECT_SITE_SITEINFO_EMPTY(81026, "选择座席失败，座席信息不存在", "选择座席失败，座席信息不存在"),
	SELECT_SITE_BANKINFO_EMPTY(81027, "选择座席失败，座席所属银商信息不存在", "选择座席失败，座席所属银商信息不存在"),


	CHAT_FORBID_ERROR(8103,"聊天室已禁用","聊天室已禁用"),
	
	NO_VALID_SITE_ERROR(8104,"无有效座席","无有效座席"),
	NO_ONLINE_SITE_ERROR(81041,"无在线座席","无在线座席"),
	SELECT_SITE_OFFLINE_ERROR(81042,"选择座席不在线","选择座席不在线"),
	
	//座席支付通道相关状态码定义
	NO_VALID_CHANNEL_ERROR(8105,"支付通道不可用","支付通道不可用"),
	
	SITE_NO_VALID_CHANNEL_EROOR(81051, "座席无有效支付通道", "座席无有效支付通道"),
	
	SITE_CHANNEL_NOT_EXIT(81052, "支付通道不存在", "支付通道不存在"),
	
	DELETE_SITE_CHANNEL_STATUS_ERROR(81053, "通道状态不允许删除，操作失败", "通道状态不允许删除，操作失败"),
	
	//座席接单相关
	CLONE_OVER_QUOTA(8110,"当前坐席额度已用完,无法续单","当前坐席额度已用完,无法续单"),
	
	SITE_OFFLINE(8111,"坐席不在线，无法续单","坐席不在线，无法续单"),
	
	DEALORDER_OVER_QUOTA(8112,"座席当日额度用完,请点重新上分","座席当日额度用完,请点重新上分"),
	
	SITE_STOP_RECEIVE(8113,"坐席已停止接单，无法续单","坐席已停止接单，无法续单"),
	
	SITE_UPDATE_QUOTA_ERROR(8114,"更新座席可用额度失败","更新座席可用额度失败"),
	
	/**银商相关**/
	BANK_CREDIT_LACK(8200,"银商信用额度不足","银商信用额度不足"),
	NO_AVAILABLE_CREDIT_BANK(82001,"无满足可用额度的银商","无满足可用额度的银商"),
	
	/**玩家相关**/
	PLAYER_NO_CHANNEL(8300,"不存在支付通道","不存在支付通道"),
	
	BANK_ADD_CREDIT_ERROR(8400,"银商授信失败,不存在银商信息","银商授信失败,不存在银商信息"),
	
	
	/**85XX 优惠活动相关错误码 **/
	DISCOUNT_ACTIVITY_ADD_ERROR(8500,"添加优惠活动失败","添加优惠活动失败"),
	DISCOUNT_ACTIVITY_EXIT_EFFECT_ERROR(8510,"该厅已存在启用的优惠活动，不能重复启用","该厅已存在启用的优惠活动，不能重复启用"),
	DISCOUNT_ACTIVITY_EMPTY(8511,"优惠活动信息不存在","优惠活动信息不存在"),
	DISCOUNT_ACTIVITY_UPDATE_STATUS_ERROR(8512,"启用中的优惠活动不能更新","启用中的优惠活动不能更新"),
	DISCOUNT_ACTIVITY_CONTENT_ERROR(8513,"优惠活动详情不合法","优惠活动详情不合法"),
	DISCOUNT_ACTIVITY_SP_NONE(8514,"厅当前无优惠活动","厅当前无优惠活动"),
	
	SYSTEM_MAINTAIN_ERROR(9000, "系统正在维护中，请稍后再试！", "%s"),
	
	NO_PERMISSION_ERROR(9001, "您没有该模块的访问权限，请与系统管理员联系！", ""),
	
	SYSTEM_RISCK_CTL(9002,"风控开启中",""),
	
	IP_ERROR(9003,"当前IP无法访问后台，请与系统管理员联系！",""),
	
	
	TOTAL_REPORT_REGEN(9401,"上次指定的报表统计数据尚在生成中，请稍后........","%s"),
	
	UNDEFINED_PARAMS_ERROR(9996, "参数解析异常！", ""),

	SPINFO_NOTEQUAL(9997, "厅主信息不一致！", ""),
	SPINFO_SITE_CHOOSEMETHODL_ERROR(99970, "座席选择模式与厅主系统配置不一致！", "座席选择模式与厅主系统配置不一致！"),
	
	RESULT_NULL(9998, "查询结果为空！", ""),
	
	DEDUCTMONEY_FAIL(9999, "扣款失败！", ""),
	
	CLOUD_SIGN_ERROR(20000,"签名为空或不正确",""),
	
	CLOUD_PLATFORM_UNUSED(20001,"平台商未配置接入秘钥，请联系系统管理员","平台商未配置接入秘钥"),
	
	CLOUD_QUERY_TIME_INTERVAL_ERROR(20002, "查询范围超过最大限制", "查询最大时间间隔不允许超过%s天"),
	
	CLOUD_METHOD_ERROR(19100,"接口不存在",""),
	
	
	USER_STATUS_ERROR(1007,"您的账号已被限制投注，请与系统管理员联系",""),
	
	
	;
	
	/**
	 * 代码
	 */
	private final int code;
	/**
	 * 信息
	 */
	private final String message;
	/**
	 * 补充信息，失败原因
	 */
	private final String reason;

	/**
	 * @param code 错误码
	 * @param message 错误信息
	 * @param reason 详细描述
	 */
	RespCode(int code, String message, String reason) {
		this.code = code;
		this.message = message;
		this.reason = reason;
	}

	/**
	 * 获得错误详细描述，并将指定参数进行格式化
	 * 
	 * <p/>
	 * @author Holin Ding
	 * @date 2017年12月2日 下午4:52:07
	 * @param params
	 * @return
	 * @throws IllegalFormatException
	 */
	public String toString(Object... params) throws IllegalFormatException {
		if (params == null || params.length == 0) {
			return reason;
		}
		return String.format(reason, params);
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	

}
