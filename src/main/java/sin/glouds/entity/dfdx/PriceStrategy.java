package sin.glouds.entity.dfdx;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yg_t_pricestrategy")
public class PriceStrategy {

	@Id
	private String id;
	private String name;
	private String pricingAccount;
	private String valuationMethod;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "specifications_id")
	private Specification specification;
	private String salverType;
	private String customer;
	private String salverNumber;
	private Double price;
	private String status;
	private Date validStartTime;
	private Date validEndTime;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private SysUser createBy;
	private Date createDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private SysUser uupdateBy;
	private Date updateDate;
	private String remarks;
	private Boolean delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPricingAccount() {
		return pricingAccount;
	}

	public void setPricingAccount(String pricingAccount) {
		this.pricingAccount = pricingAccount;
	}

	public String getValuationMethod() {
		return valuationMethod;
	}

	public void setValuationMethod(String valuationMethod) {
		this.valuationMethod = valuationMethod;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public String getSalverType() {
		return salverType;
	}

	public void setSalverType(String salverType) {
		this.salverType = salverType;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getSalverNumber() {
		return salverNumber;
	}

	public void setSalverNumber(String salverNumber) {
		this.salverNumber = salverNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getValidStartTime() {
		return validStartTime;
	}

	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}

	public Date getValidEndTime() {
		return validEndTime;
	}

	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
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

	public SysUser getUupdateBy() {
		return uupdateBy;
	}

	public void setUupdateBy(SysUser uupdateBy) {
		this.uupdateBy = uupdateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "PriceStrategy [id=" + id + ", name=" + name + ", pricingAccount=" + pricingAccount
				+ ", valuationMethod=" + valuationMethod + ", specification=" + specification + ", salverType="
				+ salverType + ", customer=" + customer + ", salverNumber=" + salverNumber + ", price=" + price
				+ ", status=" + status + ", validStartTime=" + validStartTime + ", validEndTime=" + validEndTime
				+ ", createBy=" + createBy + ", createDate=" + createDate + ", uupdateBy=" + uupdateBy + ", updateDate="
				+ updateDate + ", remarks=" + remarks + ", delFlag=" + delFlag + "]";
	}

}
