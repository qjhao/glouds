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
@Table(name = "yg_t_storedetail")
public class StoreDetail {

	@Id
	private String id;
	private String no;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
	private Store store;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "store_slave_id")
	private StoreSlave storeSlave;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "salver_id")
	private Salver salver;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "price_strategy_id")
	private PriceStrategy priceStrategy;
	private String priceAcount;
	private String valuationMethod;
	private Double deposit;
	private Double price;
	private Double damages;
	private String status;
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
	private String inStoreType;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "out_store_detail_id")
	private StoreDetail outStoreDetail;

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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public StoreSlave getStoreSlave() {
		return storeSlave;
	}

	public void setStoreSlave(StoreSlave storeSlave) {
		this.storeSlave = storeSlave;
	}

	public Salver getSalver() {
		return salver;
	}

	public void setSalver(Salver salver) {
		this.salver = salver;
	}

	public PriceStrategy getPriceStrategy() {
		return priceStrategy;
	}

	public void setPriceStrategy(PriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}

	public String getPriceAcount() {
		return priceAcount;
	}

	public void setPriceAcount(String priceAcount) {
		this.priceAcount = priceAcount;
	}

	public String getValuationMethod() {
		return valuationMethod;
	}

	public void setValuationMethod(String valuationMethod) {
		this.valuationMethod = valuationMethod;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDamages() {
		return damages;
	}

	public void setDamages(Double damages) {
		this.damages = damages;
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

	public String getInStoreType() {
		return inStoreType;
	}

	public void setInStoreType(String inStoreType) {
		this.inStoreType = inStoreType;
	}

	public StoreDetail getOutStoreDetail() {
		return outStoreDetail;
	}

	public void setOutStoreDetail(StoreDetail outStoreDetail) {
		this.outStoreDetail = outStoreDetail;
	}

	@Override
	public String toString() {
		return "StoreDetail [id=" + id + ", no=" + no + ", store=" + store + ", storeSlave=" + storeSlave + ", salver="
				+ salver + ", priceStrategy=" + priceStrategy + ", priceAcount=" + priceAcount + ", valuationMethod="
				+ valuationMethod + ", deposit=" + deposit + ", price=" + price + ", damages=" + damages + ", status="
				+ status + ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", remarks=" + remarks + ", delFlag=" + delFlag + ", inStoreType="
				+ inStoreType + ", outStoreDetil=" + outStoreDetail + "]";
	}

}
