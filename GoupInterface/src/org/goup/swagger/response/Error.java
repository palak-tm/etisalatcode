package org.goup.swagger.response;

import io.swagger.annotations.ApiModelProperty;

public class Error {

	public ErrorMessage errors;

	public ErrorMessage getErrors() {
		return errors;
	}

	public void setErrors(ErrorMessage errors) {
		this.errors = errors;
	}

	public static class ErrorMessage {

		@ApiModelProperty(value = "code")
		private String code;

		@ApiModelProperty(value = "description")
		private String description;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
