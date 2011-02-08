/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.forms.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FormsStructureEntry service. Represents a row in the &quot;FormsStructureEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.forms.model.impl.FormsStructureEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.forms.model.impl.FormsStructureEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormsStructureEntry
 * @see com.liferay.portlet.forms.model.impl.FormsStructureEntryImpl
 * @see com.liferay.portlet.forms.model.impl.FormsStructureEntryModelImpl
 * @generated
 */
public interface FormsStructureEntryModel extends BaseModel<FormsStructureEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a forms structure entry model instance should use the {@link FormsStructureEntry} interface instead.
	 */

	/**
	 * Gets the primary key of this forms structure entry.
	 *
	 * @return the primary key of this forms structure entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this forms structure entry
	 *
	 * @param pk the primary key of this forms structure entry
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this forms structure entry.
	 *
	 * @return the uuid of this forms structure entry
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this forms structure entry.
	 *
	 * @param uuid the uuid of this forms structure entry
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the structure entry ID of this forms structure entry.
	 *
	 * @return the structure entry ID of this forms structure entry
	 */
	public long getStructureEntryId();

	/**
	 * Sets the structure entry ID of this forms structure entry.
	 *
	 * @param structureEntryId the structure entry ID of this forms structure entry
	 */
	public void setStructureEntryId(long structureEntryId);

	/**
	 * Gets the group ID of this forms structure entry.
	 *
	 * @return the group ID of this forms structure entry
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this forms structure entry.
	 *
	 * @param groupId the group ID of this forms structure entry
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company ID of this forms structure entry.
	 *
	 * @return the company ID of this forms structure entry
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this forms structure entry.
	 *
	 * @param companyId the company ID of this forms structure entry
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user ID of this forms structure entry.
	 *
	 * @return the user ID of this forms structure entry
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this forms structure entry.
	 *
	 * @param userId the user ID of this forms structure entry
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this forms structure entry.
	 *
	 * @return the user uuid of this forms structure entry
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this forms structure entry.
	 *
	 * @param userUuid the user uuid of this forms structure entry
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this forms structure entry.
	 *
	 * @return the user name of this forms structure entry
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this forms structure entry.
	 *
	 * @param userName the user name of this forms structure entry
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this forms structure entry.
	 *
	 * @return the create date of this forms structure entry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this forms structure entry.
	 *
	 * @param createDate the create date of this forms structure entry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this forms structure entry.
	 *
	 * @return the modified date of this forms structure entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this forms structure entry.
	 *
	 * @param modifiedDate the modified date of this forms structure entry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the structure ID of this forms structure entry.
	 *
	 * @return the structure ID of this forms structure entry
	 */
	public String getStructureId();

	/**
	 * Sets the structure ID of this forms structure entry.
	 *
	 * @param structureId the structure ID of this forms structure entry
	 */
	public void setStructureId(String structureId);

	/**
	 * Gets the name of this forms structure entry.
	 *
	 * @return the name of this forms structure entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this forms structure entry.
	 *
	 * @param name the name of this forms structure entry
	 */
	public void setName(String name);

	/**
	 * Gets the description of this forms structure entry.
	 *
	 * @return the description of this forms structure entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this forms structure entry.
	 *
	 * @param description the description of this forms structure entry
	 */
	public void setDescription(String description);

	/**
	 * Gets the xsd of this forms structure entry.
	 *
	 * @return the xsd of this forms structure entry
	 */
	@AutoEscape
	public String getXsd();

	/**
	 * Sets the xsd of this forms structure entry.
	 *
	 * @param xsd the xsd of this forms structure entry
	 */
	public void setXsd(String xsd);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(FormsStructureEntry formsStructureEntry);

	public int hashCode();

	public FormsStructureEntry toEscapedModel();

	public String toString();

	public String toXmlString();
}