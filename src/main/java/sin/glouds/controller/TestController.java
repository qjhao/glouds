package sin.glouds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "test")
public class TestController {
	
	@RequestMapping(value = "jdgrid")
	public String jdgrid() {
		return "test/jdgrid";
	}
	
	@RequestMapping(value = "user/lg")
	@ResponseBody
	public String login(@RequestParam(required = true) String userName, @RequestParam(required = true) String passWord) {
		Data<User> data = new Data<User>();
		data.Success = true;
		data.ErrorMsg = "";
		User user = new User();
		user.setEmpNm(userName);;
		user.setPassword(passWord);
		user.setEmpId(1);
		user.setEmpNo(userName);
		data.t = user;
		return new Gson().toJson(data);
	}
}

class Data<T> {
	boolean Success;
	String ErrorMsg;
	T t;
}

class User {
	private Boolean Identity;
	private Integer IsFactoryUser;
	private Integer KingdeeUserID;
	private String RFID;
	private Integer departId;
	private String effectEndDt;
	private String email;
	private Integer empId;
	private String empNm;
	private String empNo;
	private Integer errorLoginAmmount;
	private String gender;
	private String historyPassword;
	private String internalEmployeeNo;
	private Boolean isDel;
	private Boolean isEffect;
	private Boolean isOnLine;
	private Boolean isrtDt;
	private Integer isrtEmpId;
	private String language;
	private String lastOnLineDt;
	private String mark;
	private String mobile;
	private String password;
	private String preModifyPasswordDt;
	private String sessionId;
	private Integer style;
	private String telephone;
	private String updtDt;
	private Integer updtEmpId;
	public Boolean getIdentity() {
		return Identity;
	}
	public void setIdentity(Boolean identity) {
		Identity = identity;
	}
	public Integer getIsFactoryUser() {
		return IsFactoryUser;
	}
	public void setIsFactoryUser(Integer isFactoryUser) {
		IsFactoryUser = isFactoryUser;
	}
	public Integer getKingdeeUserID() {
		return KingdeeUserID;
	}
	public void setKingdeeUserID(Integer kingdeeUserID) {
		KingdeeUserID = kingdeeUserID;
	}
	public String getRFID() {
		return RFID;
	}
	public void setRFID(String rFID) {
		RFID = rFID;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public String getEffectEndDt() {
		return effectEndDt;
	}
	public void setEffectEndDt(String effectEndDt) {
		this.effectEndDt = effectEndDt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public Integer getErrorLoginAmmount() {
		return errorLoginAmmount;
	}
	public void setErrorLoginAmmount(Integer errorLoginAmmount) {
		this.errorLoginAmmount = errorLoginAmmount;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHistoryPassword() {
		return historyPassword;
	}
	public void setHistoryPassword(String historyPassword) {
		this.historyPassword = historyPassword;
	}
	public String getInternalEmployeeNo() {
		return internalEmployeeNo;
	}
	public void setInternalEmployeeNo(String internalEmployeeNo) {
		this.internalEmployeeNo = internalEmployeeNo;
	}
	public Boolean getIsDel() {
		return isDel;
	}
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
	public Boolean getIsEffect() {
		return isEffect;
	}
	public void setIsEffect(Boolean isEffect) {
		this.isEffect = isEffect;
	}
	public Boolean getIsOnLine() {
		return isOnLine;
	}
	public void setIsOnLine(Boolean isOnLine) {
		this.isOnLine = isOnLine;
	}
	public Boolean getIsrtDt() {
		return isrtDt;
	}
	public void setIsrtDt(Boolean isrtDt) {
		this.isrtDt = isrtDt;
	}
	public Integer getIsrtEmpId() {
		return isrtEmpId;
	}
	public void setIsrtEmpId(Integer isrtEmpId) {
		this.isrtEmpId = isrtEmpId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLastOnLineDt() {
		return lastOnLineDt;
	}
	public void setLastOnLineDt(String lastOnLineDt) {
		this.lastOnLineDt = lastOnLineDt;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPreModifyPasswordDt() {
		return preModifyPasswordDt;
	}
	public void setPreModifyPasswordDt(String preModifyPasswordDt) {
		this.preModifyPasswordDt = preModifyPasswordDt;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getStyle() {
		return style;
	}
	public void setStyle(Integer style) {
		this.style = style;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUpdtDt() {
		return updtDt;
	}
	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}
	public Integer getUpdtEmpId() {
		return updtEmpId;
	}
	public void setUpdtEmpId(Integer updtEmpId) {
		this.updtEmpId = updtEmpId;
	}
	public String getFFunction() {
		return "";
	}
	
	
}
