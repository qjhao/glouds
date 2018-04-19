package sin.glouds.entity.dfdx;

import java.util.Date;

public class StoreDetail {

	private String id;
	private String no;
	private Store store;
	private StoreSlave storeSlave;
	private Salver salver;
	private PriceStrategy priceStrategy;
	private String priceAcount;
	private String valuationMethod;
	private Double deposit;
	private Double price;
	private Double damages;
	private String status;
	private SysUser createBy;
	private Date createDate;
	private SysUser updateBy;
	private Date updateDate;
	private String remarks;
	private Boolean delFlag;
	private String inStoreType;
	private StoreDetail outStoreDetil;
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
	public StoreDetail getOutStoreDetil() {
		return outStoreDetil;
	}
	public void setOutStoreDetil(StoreDetail outStoreDetil) {
		this.outStoreDetil = outStoreDetil;
	}
	
	
}
