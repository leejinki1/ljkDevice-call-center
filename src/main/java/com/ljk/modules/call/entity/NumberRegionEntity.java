package com.ljk.modules.call.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


/**
 * 号码归属表
 * 
 * @author ljk
 * @date 2018-11-03 10:07:59
 */
public class NumberRegionEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message="号码ID不能为空")
	//号码id
	private String phoneNumberId;
	@NotBlank(message="号码不能为空")
	//号码
	private String number;
	//号码归属地省
	private String province;
	//号码归属地市
	private String  city;

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	/**
	 * 设置：号码id
	 */
	public void setPhoneNumberId(String phoneNumberId){this.phoneNumberId=phoneNumberId;}
	/**
	 * 获取：号码
	 */
	public String getPhoneNumberId() {
		return phoneNumberId;
	}
	/**
	 * 设置：号码
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：号码
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：号码归属地省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：号码归属地省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：号码归属地市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：号码归属地市
	 */
	public String getCity() {
		return city;
	}

}
