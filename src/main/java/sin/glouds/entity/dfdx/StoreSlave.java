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
@Table(name = "yg_t_storeslave")
public class StoreSlave {

	@Id
	private String id;
	private String no;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "specifications_id")
	private Specification specification;
	private String salverType;
	private String inStoreType;
	private Integer realAmount;
	private Integer needAcount;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
	private Store store;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private SysUser createBy;
	private Date createDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private SysUser updateBy;
	private Date updateDate;
	private String remarks;
	private Boolean delFlag;
	private Double depositStoreSlave;
	private Double deposit;

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

	public String getInStoreType() {
		return inStoreType;
	}

	public void setInStoreType(String inStoreType) {
		this.inStoreType = inStoreType;
	}

	public Integer getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(Integer realAmount) {
		this.realAmount = realAmount;
	}

	public Integer getNeedAcount() {
		return needAcount;
	}

	public void setNeedAcount(Integer needAcount) {
		this.needAcount = needAcount;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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

	public Double getDepositStoreSlave() {
		return depositStoreSlave;
	}

	public void setDepositStoreSlave(Double depositStoreSlave) {
		this.depositStoreSlave = depositStoreSlave;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		return "StoreSlave [id=" + id + ", no=" + no + ", specification=" + specification + ", salverType=" + salverType
				+ ", inStoreType=" + inStoreType + ", realAmount=" + realAmount + ", needAcount=" + needAcount
				+ ", store=" + store + ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy="
				+ updateBy + ", updateDate=" + updateDate + ", remarks=" + remarks + ", delFlag=" + delFlag
				+ ", depositStoreSlave=" + depositStoreSlave + ", deposit=" + deposit + "]";
	}

}
