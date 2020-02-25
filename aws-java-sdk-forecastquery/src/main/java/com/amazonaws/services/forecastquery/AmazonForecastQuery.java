/*
 * Copyright 2015-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.forecastquery;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.regions.*;

import com.amazonaws.services.forecastquery.model.*;

/**
 * Interface for accessing Amazon Forecast Query Service.
 * <p>
 * <b>Note:</b> Do not directly implement this interface, new methods are added to it regularly. Extend from
 * {@link com.amazonaws.services.forecastquery.AbstractAmazonForecastQuery} instead.
 * </p>
 * <p>
 * <p>
 * Provides APIs for creating and managing Amazon Forecast resources.
 * </p>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface AmazonForecastQuery {

    /**
     * The region metadata service name for computing region endpoints. You can use this value to retrieve metadata
     * (such as supported regions) of the service.
     *
     * @see RegionUtils#getRegionsForService(String)
     */
    String ENDPOINT_PREFIX = "forecastquery";

    /**
     * <p>
     * Retrieves a forecast for a single item, filtered by the supplied criteria.
     * </p>
     * <p>
     * The criteria is a key-value pair. The key is either <code>item_id</code> (or the equivalent non-timestamp,
     * non-target field) from the <code>TARGET_TIME_SERIES</code> dataset, or one of the forecast dimensions specified
     * as part of the <code>FeaturizationConfig</code> object.
     * </p>
     * <p>
     * By default, <code>QueryForecast</code> returns the complete date range for the filtered forecast. You can request
     * a specific date range.
     * </p>
     * <p>
     * To get the full forecast, use the <a
     * href="https://docs.aws.amazon.com/en_us/forecast/latest/dg/API_CreateForecastExportJob.html"
     * >CreateForecastExportJob</a> operation.
     * </p>
     * <note>
     * <p>
     * The forecasts generated by Amazon Forecast are in the same timezone as the dataset that was used to create the
     * predictor.
     * </p>
     * </note>
     * 
     * @param queryForecastRequest
     * @return Result of the QueryForecast operation returned by the service.
     * @throws ResourceNotFoundException
     *         We can't find that resource. Check the information that you've provided and try again.
     * @throws ResourceInUseException
     *         The specified resource is in use.
     * @throws InvalidInputException
     *         The value is invalid or is too long.
     * @throws LimitExceededException
     *         The limit on the number of requests per second has been exceeded.
     * @throws InvalidNextTokenException
     *         The token is not valid. Tokens expire after 24 hours.
     * @sample AmazonForecastQuery.QueryForecast
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/forecastquery-2018-06-26/QueryForecast" target="_top">AWS
     *      API Documentation</a>
     */
    QueryForecastResult queryForecast(QueryForecastRequest queryForecastRequest);

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

    /**
     * Returns additional metadata for a previously executed successful request, typically used for debugging issues
     * where a service isn't acting as expected. This data isn't considered part of the result data returned by an
     * operation, so it's available through this separate, diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access this extra diagnostic
     * information for an executed request, you should use this method to retrieve it as soon as possible after
     * executing a request.
     *
     * @param request
     *        The originally executed request.
     *
     * @return The response metadata for the specified request, or null if none is available.
     */
    ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request);

}
