/**
 * 
 */
package org.dbrane.cloud.entity.hundsun.request;

/**
 * @author xujin </br>
 * 		KLine请求参数实体定义
 */
public class KLineRequest {
	/**
	 * 查找类别</br>
	 * 是否必填:true</br>
	 * 最大长度:1</br>
	 * 默认值:null</br>
	 * offset 按偏移查找；range 按日期区间查找；必须输入其中一个值
	 */
	private String getType;

	/**
	 * 产品代码 </br>
	 * 是否必填:true</br>
	 * 最大长度:32</br>
	 * 默认值:null</br>
	 * 有且仅能有 1 个代码；证券代码包含交易所代码做后缀，作为该代码的唯一标识。如：600570.SS
	 */
	private String prodCode;

	/**
	 * K线周期 </br>
	 * 是否必填:true</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 * 取值可以是数字1-9，表示含义如下： 1：1分钟K线 2：5分钟K线 3：15分钟K线 4：30分钟K线 5：60分钟K线 6：日K线 7：周K线
	 * 8：月K线 9：年K线
	 */
	private Integer candlePeriod;

	/**
	 * K线模式</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:0</br>
	 * 0：原始K线 1：前复权K线 2：后复权K线
	 */
	private Integer candleMode;

	/**
	 * 字段集合</br>
	 * 是否必填:false</br>
	 * 最大长度:255</br>
	 * 默认值:null</br>
	 * 允许的字段： 开盘价：open_px 最高价：high_px 最低价：low_px 收盘价：close_px
	 * 成交量：business_amount 成交额：business_balance 如果没有指定任何有效的字段，则返回所有字段
	 */
	private String fields;

	/**
	 * 搜索方向</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:1</br>
	 * 1 表示向前查找（默认值） ，2 表示向后查找。 仅在 get_type=offset 时有效。
	 */
	private Integer searchDirection;

	/**
	 * 日期</br>
	 * 是否必填:false</br>
	 * 最大长度:8</br>
	 * 默认值:null</br>
	 * 不输入默认为当前日期；请求日K线时，如果输入日期，不返回该日期的K线 get_type=offset时有效
	 */
	private Integer date;

	/**
	 * 分时分钟时间(HHMM) </br>
	 * 是否必填:false </br>
	 * 最大长度:10 </br>
	 * 默认值:null </br>
	 * 分钟 K 线的时间 HHMM,对于 短 周期 K 线 类型 使用(1min,5min 等)，不填写表示最新的市场时间，若填写必须同时填写 date
	 * 字段。请求分钟K线时，如果输入该字段，不返回输入分钟的K线 仅在 get_type=offset 且candle_period=1~5（分钟
	 * K线）时有效。
	 */
	private Integer minTime;

	/**
	 * 数据个数</br>
	 * 是否必填:false </br>
	 * 最大长度:10 </br>
	 * 默认值:10 </br>
	 * 需要取得的 K 线的根数，如果该字段不存在，取值范围[1, 1000]，默认为 10 个。 仅在 get_type=offset 时有效。
	 */
	private Integer dataCount;

	/**
	 * 开始日期</br>
	 * 是否必填:false </br>
	 * 最大长度:8 </br>
	 * 默认值:null </br>
	 * 1、 start_date 和 end_date 均不填， 返回距离当前日期的1000 根 K 线； 2、 仅填 start_date， 当
	 * start_date和最新日期之间的数据不足1000 根，返回 start_date 和最新日期之间的数据；如果数据超过 1000 根 K 线，
	 * 则返回距离当前日期的 1000 根 K线； 3、 仅填 end_date ， 返 回end_date 之前存在的的最多1000 根 K 线； 4、
	 * start_date 和 end_date 均填充，返回该日期区间（闭区间）的数据，最多 1000 根。 仅在 get_type=range
	 * 时有效。
	 */
	private Integer startDate;

	/**
	 * 截止日期</br>
	 * 是否必填:false </br>
	 * 最大长度:8 </br>
	 * 默认值:null </br>
	 * 默认为当前日期； 1、 start_date 和 end_date 均不填， 返回距离当前日期的1000 根 K 线； 2、 仅填
	 * start_date， 当 start_date和最新日期之间的数据不足1000 根，返回 start_date
	 * 和最新日期之间的数据；如果数据超过 1000 根 K 线， 则返回距离当前日期的 1000 根 K线； 3、 仅填 end_date ， 返
	 * 回end_date 之前存在的的最多1000 根 K 线； 4、 start_date 和 end_date
	 * 均填充，返回该日期区间（闭区间）的数据，最多 1000 根。 仅在 get_type=range 时有效。
	 */
	private Integer endDate;

	/**
	 * @return the getType
	 */
	public String getGetType() {
		return getType;
	}

	/**
	 * @param getType
	 *            the getType to set
	 */
	public void setGetType(String getType) {
		this.getType = getType;
	}

	/**
	 * @return the prodCode
	 */
	public String getProdCode() {
		return prodCode;
	}

	/**
	 * @param prodCode
	 *            the prodCode to set
	 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	/**
	 * @return the candlePeriod
	 */
	public Integer getCandlePeriod() {
		return candlePeriod;
	}

	/**
	 * @param candlePeriod
	 *            the candlePeriod to set
	 */
	public void setCandlePeriod(Integer candlePeriod) {
		this.candlePeriod = candlePeriod;
	}

	/**
	 * @return the candleMode
	 */
	public Integer getCandleMode() {
		return candleMode;
	}

	/**
	 * @param candleMode
	 *            the candleMode to set
	 */
	public void setCandleMode(Integer candleMode) {
		this.candleMode = candleMode;
	}

	/**
	 * @return the fields
	 */
	public String getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(String fields) {
		this.fields = fields;
	}

	/**
	 * @return the searchDirection
	 */
	public Integer getSearchDirection() {
		return searchDirection;
	}

	/**
	 * @param searchDirection
	 *            the searchDirection to set
	 */
	public void setSearchDirection(Integer searchDirection) {
		this.searchDirection = searchDirection;
	}

	/**
	 * @return the date
	 */
	public Integer getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Integer date) {
		this.date = date;
	}

	/**
	 * @return the minTime
	 */
	public Integer getMinTime() {
		return minTime;
	}

	/**
	 * @param minTime
	 *            the minTime to set
	 */
	public void setMinTime(Integer minTime) {
		this.minTime = minTime;
	}

	/**
	 * @return the dataCount
	 */
	public Integer getDataCount() {
		return dataCount;
	}

	/**
	 * @param dataCount
	 *            the dataCount to set
	 */
	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}

	/**
	 * @return the startDate
	 */
	public Integer getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Integer getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString(){
		return "?get_type=offset&prod_code=600570.SS&candle_period=1&fields=open_px,high_px,low_px,close_px&search_direction=2&date=20150106&min_time=1400&data_count=20";
	}

}
