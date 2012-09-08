/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.cohortbuilder.web.dwr;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.service.CohortDefinitionService;

/**
 * Processes DWR calls for the module
 */
public class DWRCohortBuilderService {
	
	protected Log log = LogFactory.getLog(getClass());
	
	public List<DefinitionListItem> getDefinitions(String name) {
		List<CohortDefinition> definitions = Context.getService(CohortDefinitionService.class).getDefinitions(name, false);
		List<DefinitionListItem> results = new ArrayList<DefinitionListItem>();
		for (CohortDefinition definition : definitions) {
			results.add(new DefinitionListItem(definition));
		}
		return results;
	}
}