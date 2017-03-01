/**
 * 
 */
package com.prokarma.health.domain;

import org.springframework.util.StringUtils;

/**
 * @author ProKarma
 *
 */
public class LoginUser {
		private int id;
		private String userId;
		private String password;
		private boolean authorized;
		private String userType;
		private String validicUserId;
		private String validicUserAccessToken;
		private boolean isRegisterWithValidic;
		private String organizationId;
		private String validicOrganizationAccessToken;
		
		
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isAuthorized() {
			return authorized;
		}
		public void setAuthorized(boolean authorized) {
			this.authorized = authorized;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getValidicUserAccessToken() {
			return validicUserAccessToken;
		}
		public void setValidicUserAccessToken(String validicUserAccessToken) {
			this.validicUserAccessToken = validicUserAccessToken;
		}
		public boolean isRegisterWithValidic() {
			return !StringUtils.isEmpty(this.getValidicUserId());
		}
		public void setRegisterWithValidic(boolean isRegisterWithValidic) {
			this.isRegisterWithValidic = isRegisterWithValidic;
		}
		public String getValidicUserId() {
			return validicUserId;
		}
		public void setValidicUserId(String validicUserId) {
			this.validicUserId = validicUserId;
		}
		
		public boolean hasValidicUserId() {
			return !StringUtils.isEmpty(getValidicUserId());
		}
		 
		public boolean hasValidicUserAccessToken() {
			  return !StringUtils.isEmpty(getValidicUserAccessToken());
		}
		public String getOrganizationId() {
			return organizationId;
		}
		public void setOrganizationId(String organizationId) {
			this.organizationId = organizationId;
		}
		public String getValidicOrganizationAccessToken() {
			return validicOrganizationAccessToken;
		}
		public void setValidicOrganizationAccessToken(
				String validicOrganizationAccessToken) {
			this.validicOrganizationAccessToken = validicOrganizationAccessToken;
		}
		
}
