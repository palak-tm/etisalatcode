package org.goup.request.model;

import java.util.List;

public class DeviceHistoryList {

	private List<DeviceHistoryItem> deviceHistoryItem;
	
	
	public List<DeviceHistoryItem> getDeviceHistoryItem() {
		return deviceHistoryItem;
	}


	public void setDeviceHistoryItem(List<DeviceHistoryItem> deviceHistoryItem) {
		this.deviceHistoryItem = deviceHistoryItem;
	}


	public static class DeviceHistoryItem
	{
		private String timestamp;
		private String operation;
		private String customerServiceProfileName;
		private String state;
		private String baseCountry;
		private String imei;
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getOperation() {
			return operation;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		public String getCustomerServiceProfileName() {
			return customerServiceProfileName;
		}
		public void setCustomerServiceProfileName(String customerServiceProfileName) {
			this.customerServiceProfileName = customerServiceProfileName;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getBaseCountry() {
			return baseCountry;
		}
		public void setBaseCountry(String baseCountry) {
			this.baseCountry = baseCountry;
		}
		public String getImei() {
			return imei;
		}
		public void setImei(String imei) {
			this.imei = imei;
		}
		
		
	}
}
