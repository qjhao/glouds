package sin.glouds.entity.dfdx;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yg_t_salver")
public class Salver {

	@Id
	private String id;
	private String name;
	private String code;
	private String barCode;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "specifications_id")
	private Specification specification;
	private String category;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "storehouse_id")
	private StoreHouse storeHouse;
	private String status;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private SysUser createBy;
	private Date createDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private SysUser updateBy;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public StoreHouse getStoreHouse() {
		return storeHouse;
	}

	public void setStoreHouse(StoreHouse storeHouse) {
		this.storeHouse = storeHouse;
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
		return "Salver [id=" + id + ", name=" + name + ", code=" + code + ", barCode=" + barCode + ", specification="
				+ specification + ", category=" + category + ", storeHouse=" + storeHouse + ", status=" + status
				+ ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate="
				+ updateDate + ", remarks=" + remarks + ", delFlag=" + delFlag + "]";
	}

}