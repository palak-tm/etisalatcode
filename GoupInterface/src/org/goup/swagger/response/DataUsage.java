package org.goup.swagger.response;

import java.util.List;

public class DataUsage {

	private List<DataUsageParameter> simsDataUsage;
	
	
	public List<DataUsageParameter> getDataUsageParameters() {
		return simsDataUsage;
	}


	public void setDataUsageParameters(List<DataUsageParameter> simsDataUsage) {
		this.simsDataUsage = simsDataUsage;
	}


	public static class DataUsageParameter
	{

		private String iccid;
		private String imsi;
		private String msisdn;
		private String dataUsage;
		private String sessionStartDate;
		private String sessionEndDate;
		private String duration;
		public String getIccid() {
			return iccid;
		}
		public void setIccid(String iccid) {
			this.iccid = iccid;
		}
		public String getImsi() {
			return imsi;
		}
		public void setImsi(String imsi) {
			this.imsi = imsi;
		}
		public String getMsisdn() {
			return msisdn;
		}
		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}
		public String getDataUsage() {
			return dataUsage;
		}
		public void setDataUsage(String dataUsage) {
			this.dataUsage = dataUsage;
		}
		public String getSessionStartDate() {
			return sessionStartDate;
		}
		public void setSessionStartDate(String sessionStartDate) {
			this.sessionStartDate = sessionStartDate;
		}
		public String getSessionEndDate() {
			return sessionEndDate;
		}
		public void setSessionEndDate(String sessionEndDate) {
			this.sessionEndDate = sessionEndDate;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
	
	}
	
}
