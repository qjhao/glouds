package sin.glouds.entity.dfdx;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "yg_t_store")
public class Store {

	@Id
	private String id;
	private String no;
	private String customer;
	private String contacts;
	private String phone;
	private String idNumber;
	private String useArea;
	private String type;
	private String status;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private SysUser createBy;
	private Date createDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private SysUser updateBy;
	private Date updateDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "identify_by")
	private SysUser identifyBy;
	private Date identifyDate;
	private Boolean delFlag;
	private String payType;
	private String remarks;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "finish_by")
	private SysUser finishBy;
	private Date finishDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "unfinish_by")
	private SysUser unfinishBy;
	private Date unfinishDate;
	private Integer printcount;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private List<StoreDetail> details;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private List<StoreSlave> slaves;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getUseArea() {
		return useArea;
	}

	public void setUseArea(String useArea) {
		this.useArea = useArea;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SysUser getCreateBy() {
		return createBy;
	}

	public void setCreateBy(SysUser createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public SysUser getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(SysUser updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public SysUser getIdentifyBy() {
		return identifyBy;
	}

	public void setIdentifyBy(SysUser identifyBy) {
		this.identifyBy = identifyBy;
	}

	public Date getIdentifyDate() {
		return identifyDate;
	}

	public void setIdentifyDate(Date identifyDate) {
		this.identifyDate = identifyDate;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public SysUser getFinishBy() {
		return finishBy;
	}

	public void setFinishBy(SysUser finishBy) {
		this.finishBy = finishBy;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public SysUser getUnfinishBy() {
		return unfinishBy;
	}

	public void setUnfinishBy(SysUser unfinishBy) {
		this.unfinishBy = unfinishBy;
	}

	public Date getUnfinishDate() {
		return unfinishDate;
	}

	public void setUnfinishDate(Date unfinishDate) {
		this.unfinishDate = unfinishDate;
	}

	public Integer getPrintcount() {
		return printcount;
	}

	public void setPrintcount(Integer printcount) {
		this.printcount = printcount;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", no=" + no + ", customer=" + customer + ", contacts=" + contacts + ", phone="
				+ phone + ", idNumber=" + idNumber + ", useArea=" + useArea + ", type=" + type + ", status=" + status
				+ ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate="
				+ updateDate + ", identifyBy=" + identifyBy + ", identifyDate=" + identifyDate + ", delFlag=" + delFlag
				+ ", payType=" + payType + ", remarks=" + remarks + ", finishBy=" + finishBy + ", finishDate="
				+ finishDate + ", unfinishBy=" + unfinishBy + ", unfinishDate=" + unfinishDate + ", printCount="
				+ printcount + ", details=" + details + ", slaves=" + slaves + "]";
	}

}
