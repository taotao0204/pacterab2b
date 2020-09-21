/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.pactera.initialdata.impl;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;


/**
 * Implementation to handle specific Core Data Import services to Powertools.
 */
public class Pacterab2bCoreDataImportService extends CoreDataImportService
{
	/**
	 * Imports store data related to Powertools. Imports a site-override impex if available.
	 *
	 * @param extensionName
	 *           the extension name used.
	 * @param storeName
	 *           the store to import for.
	 * @param productCatalogName
	 *           the product catalog used.
	 */
	@Override
	protected void importStore(final String extensionName, final String storeName, final String productCatalogName)
	{
		super.importStore(extensionName, storeName, productCatalogName);

		if (getConfigurationService().getConfiguration().getBoolean("setup.siteoverride", false))
		{
			getSetupImpexService()
					.importImpexFile(String.format("/%s/import/coredata/stores/%s/site-override.impex", extensionName, storeName), false);
		}
	}
}
