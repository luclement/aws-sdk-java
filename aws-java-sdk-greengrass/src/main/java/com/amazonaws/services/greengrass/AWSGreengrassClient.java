/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.greengrass;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.auth.*;

import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.internal.auth.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.services.greengrass.AWSGreengrassClientBuilder;

import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.greengrass.model.*;
import com.amazonaws.services.greengrass.model.transform.*;

/**
 * Client for accessing AWS Greengrass. All service calls made using this client are blocking, and will not return until
 * the service call completes.
 * <p>
 * AWS Greengrass seamlessly extends AWS onto physical devices so they can act locally on the data they generate, while
 * still using the cloud for management, analytics, and durable storage. AWS Greengrass ensures your devices can respond
 * quickly to local events and operate with intermittent connectivity. AWS Greengrass minimizes the cost of transmitting
 * data to the cloud by allowing you to author AWS Lambda functions that execute locally.
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AWSGreengrassClient extends AmazonWebServiceClient implements AWSGreengrass {
    /** Provider for AWS credentials. */
    private final AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AWSGreengrass.class);

    /** Default signing name for the service. */
    private static final String DEFAULT_SIGNING_NAME = "greengrass";

    /** Client configuration factory providing ClientConfigurations tailored to this client */
    protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();

    private final com.amazonaws.protocol.json.SdkJsonProtocolFactory protocolFactory = new com.amazonaws.protocol.json.SdkJsonProtocolFactory(
            new JsonClientMetadata()
                    .withProtocolVersion("1.1")
                    .withSupportsCbor(false)
                    .withSupportsIon(false)
                    .withContentTypeOverride("")
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("BadRequestException").withModeledClass(
                                    com.amazonaws.services.greengrass.model.BadRequestException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InternalServerErrorException").withModeledClass(
                                    com.amazonaws.services.greengrass.model.InternalServerErrorException.class))
                    .withBaseServiceExceptionClass(com.amazonaws.services.greengrass.model.AWSGreengrassException.class));

    public static AWSGreengrassClientBuilder builder() {
        return AWSGreengrassClientBuilder.standard();
    }

    /**
     * Constructs a new client to invoke service methods on AWS Greengrass using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AWSGreengrassClient(AwsSyncClientParams clientParams) {
        super(clientParams);
        this.awsCredentialsProvider = clientParams.getCredentialsProvider();
        init();
    }

    private void init() {
        setServiceNameIntern(DEFAULT_SIGNING_NAME);
        setEndpointPrefix(ENDPOINT_PREFIX);
        // calling this.setEndPoint(...) will also modify the signer accordingly
        setEndpoint("greengrass.us-east-1.amazonaws.com");
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazonaws/services/greengrass/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazonaws/services/greengrass/request.handler2s"));
        requestHandler2s.addAll(chainFactory.getGlobalHandlers());
    }

    /**
     * Associates a role with a group. The role will be used by the AWS Greengrass core in order to access AWS cloud
     * services. The role's permissions will allow Greengrass core Lambda functions to perform actions against the
     * cloud.
     * 
     * @param associateRoleToGroupRequest
     * @return Result of the AssociateRoleToGroup operation returned by the service.
     * @throws BadRequestException
     *         User Error
     * @throws InternalServerErrorException
     *         Server Error
     * @sample AWSGreengrass.AssociateRoleToGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/AssociateRoleToGroup"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AssociateRoleToGroupResult associateRoleToGroup(AssociateRoleToGroupRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateRoleToGroup(request);
    }

    @SdkInternalApi
    final AssociateRoleToGroupResult executeAssociateRoleToGroup(AssociateRoleToGroupRequest associateRoleToGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(associateRoleToGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateRoleToGroupRequest> request = null;
        Response<AssociateRoleToGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateRoleToGroupRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(associateRoleToGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<AssociateRoleToGroupResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new AssociateRoleToGroupResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Associates a role which is used by AWS Greengrass. AWS Greengrass uses the role to access your Lambda functions
     * and AWS IoT resources. This is necessary for deployments to succeed. It needs to have minimum permissions in
     * policy ``AWSGreengrassResourceAccessRolePolicy``
     * 
     * @param associateServiceRoleToAccountRequest
     * @return Result of the AssociateServiceRoleToAccount operation returned by the service.
     * @throws BadRequestException
     *         User Error
     * @throws InternalServerErrorException
     *         Server Error
     * @sample AWSGreengrass.AssociateServiceRoleToAccount
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/AssociateServiceRoleToAccount"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AssociateServiceRoleToAccountResult associateServiceRoleToAccount(AssociateServiceRoleToAccountRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateServiceRoleToAccount(request);
    }

    @SdkInternalApi
    final AssociateServiceRoleToAccountResult executeAssociateServiceRoleToAccount(AssociateServiceRoleToAccountRequest associateServiceRoleToAccountRequest) {

        ExecutionContext executionContext = createExecutionContext(associateServiceRoleToAccountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateServiceRoleToAccountRequest> request = null;
        Response<AssociateServiceRoleToAccountResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateServiceRoleToAccountRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(associateServiceRoleToAccountRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<AssociateServiceRoleToAccountResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new AssociateServiceRoleToAccountResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a core definition. You may optionally provide the initial version of the core definition or use
     * ''CreateCoreDefinitionVersion'' at a later time. AWS Greengrass Groups must each contain exactly 1 AWS Greengrass
     * Core.
     * 
     * @param createCoreDefinitionRequest
     *        Information on the core definition request
     * @return Result of the CreateCoreDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateCoreDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateCoreDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateCoreDefinitionResult createCoreDefinition(CreateCoreDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateCoreDefinition(request);
    }

    @SdkInternalApi
    final CreateCoreDefinitionResult executeCreateCoreDefinition(CreateCoreDefinitionRequest createCoreDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(createCoreDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCoreDefinitionRequest> request = null;
        Response<CreateCoreDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCoreDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createCoreDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateCoreDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateCoreDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a version of a core definition that has already been defined. AWS Greengrass Groups must each contain
     * exactly 1 AWS Greengrass Core.
     * 
     * @param createCoreDefinitionVersionRequest
     * @return Result of the CreateCoreDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateCoreDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateCoreDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateCoreDefinitionVersionResult createCoreDefinitionVersion(CreateCoreDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateCoreDefinitionVersion(request);
    }

    @SdkInternalApi
    final CreateCoreDefinitionVersionResult executeCreateCoreDefinitionVersion(CreateCoreDefinitionVersionRequest createCoreDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createCoreDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCoreDefinitionVersionRequest> request = null;
        Response<CreateCoreDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCoreDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createCoreDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateCoreDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateCoreDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a deployment.
     * 
     * @param createDeploymentRequest
     * @return Result of the CreateDeployment operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @sample AWSGreengrass.CreateDeployment
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateDeployment" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateDeploymentResult createDeployment(CreateDeploymentRequest request) {
        request = beforeClientExecution(request);
        return executeCreateDeployment(request);
    }

    @SdkInternalApi
    final CreateDeploymentResult executeCreateDeployment(CreateDeploymentRequest createDeploymentRequest) {

        ExecutionContext executionContext = createExecutionContext(createDeploymentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDeploymentRequest> request = null;
        Response<CreateDeploymentResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDeploymentRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createDeploymentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateDeploymentResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateDeploymentResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a device definition. You may optinally provide the initial version of the device definition or use
     * ``CreateDeviceDefinitionVersion`` at a later time.
     * 
     * @param createDeviceDefinitionRequest
     * @return Result of the CreateDeviceDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateDeviceDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateDeviceDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateDeviceDefinitionResult createDeviceDefinition(CreateDeviceDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateDeviceDefinition(request);
    }

    @SdkInternalApi
    final CreateDeviceDefinitionResult executeCreateDeviceDefinition(CreateDeviceDefinitionRequest createDeviceDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(createDeviceDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDeviceDefinitionRequest> request = null;
        Response<CreateDeviceDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDeviceDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createDeviceDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateDeviceDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateDeviceDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a version of a device definition that has already been defined.
     * 
     * @param createDeviceDefinitionVersionRequest
     * @return Result of the CreateDeviceDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateDeviceDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateDeviceDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateDeviceDefinitionVersionResult createDeviceDefinitionVersion(CreateDeviceDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateDeviceDefinitionVersion(request);
    }

    @SdkInternalApi
    final CreateDeviceDefinitionVersionResult executeCreateDeviceDefinitionVersion(CreateDeviceDefinitionVersionRequest createDeviceDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createDeviceDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDeviceDefinitionVersionRequest> request = null;
        Response<CreateDeviceDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDeviceDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createDeviceDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateDeviceDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateDeviceDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a Lambda function definition which contains a list of Lambda functions and their configurations to be
     * used in a group. You can create an initial version of the definition by providing a list of Lambda functions and
     * their configurations now, or use ``CreateFunctionDefinitionVersion`` later.
     * 
     * @param createFunctionDefinitionRequest
     * @return Result of the CreateFunctionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateFunctionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateFunctionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateFunctionDefinitionResult createFunctionDefinition(CreateFunctionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateFunctionDefinition(request);
    }

    @SdkInternalApi
    final CreateFunctionDefinitionResult executeCreateFunctionDefinition(CreateFunctionDefinitionRequest createFunctionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(createFunctionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateFunctionDefinitionRequest> request = null;
        Response<CreateFunctionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateFunctionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createFunctionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateFunctionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateFunctionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Create a version of a Lambda function definition that has already been defined.
     * 
     * @param createFunctionDefinitionVersionRequest
     *        Function definition version
     * @return Result of the CreateFunctionDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateFunctionDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateFunctionDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateFunctionDefinitionVersionResult createFunctionDefinitionVersion(CreateFunctionDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateFunctionDefinitionVersion(request);
    }

    @SdkInternalApi
    final CreateFunctionDefinitionVersionResult executeCreateFunctionDefinitionVersion(
            CreateFunctionDefinitionVersionRequest createFunctionDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createFunctionDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateFunctionDefinitionVersionRequest> request = null;
        Response<CreateFunctionDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateFunctionDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createFunctionDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateFunctionDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateFunctionDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a group. You may optionally provide the initial version of the group or use ''CreateGroupVersion'' at a
     * later time.
     * 
     * @param createGroupRequest
     * @return Result of the CreateGroup operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateGroupResult createGroup(CreateGroupRequest request) {
        request = beforeClientExecution(request);
        return executeCreateGroup(request);
    }

    @SdkInternalApi
    final CreateGroupResult executeCreateGroup(CreateGroupRequest createGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(createGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateGroupRequest> request = null;
        Response<CreateGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateGroupRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateGroupResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateGroupResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a CA for the group. If a CA already exists, it will rotate the existing CA.
     * 
     * @param createGroupCertificateAuthorityRequest
     * @return Result of the CreateGroupCertificateAuthority operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @throws InternalServerErrorException
     *         The server encountered an unexpected error.
     * @sample AWSGreengrass.CreateGroupCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateGroupCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateGroupCertificateAuthorityResult createGroupCertificateAuthority(CreateGroupCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeCreateGroupCertificateAuthority(request);
    }

    @SdkInternalApi
    final CreateGroupCertificateAuthorityResult executeCreateGroupCertificateAuthority(
            CreateGroupCertificateAuthorityRequest createGroupCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(createGroupCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateGroupCertificateAuthorityRequest> request = null;
        Response<CreateGroupCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateGroupCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createGroupCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateGroupCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateGroupCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a version of a group which has already been defined.
     * 
     * @param createGroupVersionRequest
     * @return Result of the CreateGroupVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateGroupVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateGroupVersion" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateGroupVersionResult createGroupVersion(CreateGroupVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateGroupVersion(request);
    }

    @SdkInternalApi
    final CreateGroupVersionResult executeCreateGroupVersion(CreateGroupVersionRequest createGroupVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createGroupVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateGroupVersionRequest> request = null;
        Response<CreateGroupVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateGroupVersionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createGroupVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateGroupVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateGroupVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a logger definition. You may optionally provide the initial version of the logger definition or use
     * ``CreateLoggerDefinitionVersion`` at a later time.
     * 
     * @param createLoggerDefinitionRequest
     * @return Result of the CreateLoggerDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateLoggerDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateLoggerDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateLoggerDefinitionResult createLoggerDefinition(CreateLoggerDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateLoggerDefinition(request);
    }

    @SdkInternalApi
    final CreateLoggerDefinitionResult executeCreateLoggerDefinition(CreateLoggerDefinitionRequest createLoggerDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(createLoggerDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateLoggerDefinitionRequest> request = null;
        Response<CreateLoggerDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateLoggerDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createLoggerDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateLoggerDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateLoggerDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a version of a logger definition that has already been defined.
     * 
     * @param createLoggerDefinitionVersionRequest
     * @return Result of the CreateLoggerDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateLoggerDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateLoggerDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateLoggerDefinitionVersionResult createLoggerDefinitionVersion(CreateLoggerDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateLoggerDefinitionVersion(request);
    }

    @SdkInternalApi
    final CreateLoggerDefinitionVersionResult executeCreateLoggerDefinitionVersion(CreateLoggerDefinitionVersionRequest createLoggerDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createLoggerDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateLoggerDefinitionVersionRequest> request = null;
        Response<CreateLoggerDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateLoggerDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createLoggerDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateLoggerDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateLoggerDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a subscription definition. You may optionally provide the initial version of the subscription definition
     * or use ``CreateSubscriptionDefinitionVersion`` at a later time.
     * 
     * @param createSubscriptionDefinitionRequest
     * @return Result of the CreateSubscriptionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateSubscriptionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateSubscriptionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateSubscriptionDefinitionResult createSubscriptionDefinition(CreateSubscriptionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateSubscriptionDefinition(request);
    }

    @SdkInternalApi
    final CreateSubscriptionDefinitionResult executeCreateSubscriptionDefinition(CreateSubscriptionDefinitionRequest createSubscriptionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(createSubscriptionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSubscriptionDefinitionRequest> request = null;
        Response<CreateSubscriptionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSubscriptionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createSubscriptionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateSubscriptionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateSubscriptionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Creates a version of a subscription definition which has already been defined.
     * 
     * @param createSubscriptionDefinitionVersionRequest
     * @return Result of the CreateSubscriptionDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.CreateSubscriptionDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/CreateSubscriptionDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateSubscriptionDefinitionVersionResult createSubscriptionDefinitionVersion(CreateSubscriptionDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateSubscriptionDefinitionVersion(request);
    }

    @SdkInternalApi
    final CreateSubscriptionDefinitionVersionResult executeCreateSubscriptionDefinitionVersion(
            CreateSubscriptionDefinitionVersionRequest createSubscriptionDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createSubscriptionDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSubscriptionDefinitionVersionRequest> request = null;
        Response<CreateSubscriptionDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSubscriptionDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createSubscriptionDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateSubscriptionDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateSubscriptionDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Deletes a core definition. The core definition must not have been used in a deployment.
     * 
     * @param deleteCoreDefinitionRequest
     * @return Result of the DeleteCoreDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.DeleteCoreDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DeleteCoreDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteCoreDefinitionResult deleteCoreDefinition(DeleteCoreDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteCoreDefinition(request);
    }

    @SdkInternalApi
    final DeleteCoreDefinitionResult executeDeleteCoreDefinition(DeleteCoreDefinitionRequest deleteCoreDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteCoreDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteCoreDefinitionRequest> request = null;
        Response<DeleteCoreDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCoreDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(deleteCoreDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteCoreDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteCoreDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Deletes a device definition. The device definition must not have been used in a deployment.
     * 
     * @param deleteDeviceDefinitionRequest
     * @return Result of the DeleteDeviceDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.DeleteDeviceDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DeleteDeviceDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteDeviceDefinitionResult deleteDeviceDefinition(DeleteDeviceDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteDeviceDefinition(request);
    }

    @SdkInternalApi
    final DeleteDeviceDefinitionResult executeDeleteDeviceDefinition(DeleteDeviceDefinitionRequest deleteDeviceDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteDeviceDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteDeviceDefinitionRequest> request = null;
        Response<DeleteDeviceDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteDeviceDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(deleteDeviceDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteDeviceDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DeleteDeviceDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Deletes a Lambda function definition. The Lambda function definition must not have been used in a deployment.
     * 
     * @param deleteFunctionDefinitionRequest
     * @return Result of the DeleteFunctionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.DeleteFunctionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DeleteFunctionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteFunctionDefinitionResult deleteFunctionDefinition(DeleteFunctionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteFunctionDefinition(request);
    }

    @SdkInternalApi
    final DeleteFunctionDefinitionResult executeDeleteFunctionDefinition(DeleteFunctionDefinitionRequest deleteFunctionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteFunctionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteFunctionDefinitionRequest> request = null;
        Response<DeleteFunctionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteFunctionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(deleteFunctionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteFunctionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DeleteFunctionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Deletes a group. The group must not have been used in deployment.
     * 
     * @param deleteGroupRequest
     * @return Result of the DeleteGroup operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.DeleteGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DeleteGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteGroupResult deleteGroup(DeleteGroupRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteGroup(request);
    }

    @SdkInternalApi
    final DeleteGroupResult executeDeleteGroup(DeleteGroupRequest deleteGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteGroupRequest> request = null;
        Response<DeleteGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteGroupRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(deleteGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteGroupResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteGroupResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Deletes a logger definition. The logger definition must not have been used in a deployment.
     * 
     * @param deleteLoggerDefinitionRequest
     * @return Result of the DeleteLoggerDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.DeleteLoggerDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DeleteLoggerDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteLoggerDefinitionResult deleteLoggerDefinition(DeleteLoggerDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteLoggerDefinition(request);
    }

    @SdkInternalApi
    final DeleteLoggerDefinitionResult executeDeleteLoggerDefinition(DeleteLoggerDefinitionRequest deleteLoggerDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteLoggerDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteLoggerDefinitionRequest> request = null;
        Response<DeleteLoggerDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteLoggerDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(deleteLoggerDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteLoggerDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DeleteLoggerDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Deletes a subscription definition. The subscription definition must not have been used in a deployment.
     * 
     * @param deleteSubscriptionDefinitionRequest
     * @return Result of the DeleteSubscriptionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.DeleteSubscriptionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DeleteSubscriptionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteSubscriptionDefinitionResult deleteSubscriptionDefinition(DeleteSubscriptionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteSubscriptionDefinition(request);
    }

    @SdkInternalApi
    final DeleteSubscriptionDefinitionResult executeDeleteSubscriptionDefinition(DeleteSubscriptionDefinitionRequest deleteSubscriptionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteSubscriptionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteSubscriptionDefinitionRequest> request = null;
        Response<DeleteSubscriptionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteSubscriptionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(deleteSubscriptionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteSubscriptionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DeleteSubscriptionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Disassociates the role from a group.
     * 
     * @param disassociateRoleFromGroupRequest
     * @return Result of the DisassociateRoleFromGroup operation returned by the service.
     * @throws BadRequestException
     *         User Error
     * @throws InternalServerErrorException
     *         Server Error
     * @sample AWSGreengrass.DisassociateRoleFromGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DisassociateRoleFromGroup"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisassociateRoleFromGroupResult disassociateRoleFromGroup(DisassociateRoleFromGroupRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateRoleFromGroup(request);
    }

    @SdkInternalApi
    final DisassociateRoleFromGroupResult executeDisassociateRoleFromGroup(DisassociateRoleFromGroupRequest disassociateRoleFromGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateRoleFromGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateRoleFromGroupRequest> request = null;
        Response<DisassociateRoleFromGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateRoleFromGroupRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(disassociateRoleFromGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DisassociateRoleFromGroupResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DisassociateRoleFromGroupResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Disassociates the service role from the account. Without a service role, deployments will not work.
     * 
     * @param disassociateServiceRoleFromAccountRequest
     * @return Result of the DisassociateServiceRoleFromAccount operation returned by the service.
     * @throws InternalServerErrorException
     *         Server Error
     * @sample AWSGreengrass.DisassociateServiceRoleFromAccount
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/DisassociateServiceRoleFromAccount"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisassociateServiceRoleFromAccountResult disassociateServiceRoleFromAccount(DisassociateServiceRoleFromAccountRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateServiceRoleFromAccount(request);
    }

    @SdkInternalApi
    final DisassociateServiceRoleFromAccountResult executeDisassociateServiceRoleFromAccount(
            DisassociateServiceRoleFromAccountRequest disassociateServiceRoleFromAccountRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateServiceRoleFromAccountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateServiceRoleFromAccountRequest> request = null;
        Response<DisassociateServiceRoleFromAccountResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateServiceRoleFromAccountRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(disassociateServiceRoleFromAccountRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DisassociateServiceRoleFromAccountResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DisassociateServiceRoleFromAccountResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves the role associated with a particular group.
     * 
     * @param getAssociatedRoleRequest
     * @return Result of the GetAssociatedRole operation returned by the service.
     * @throws BadRequestException
     *         User Error
     * @throws InternalServerErrorException
     *         Server Error
     * @sample AWSGreengrass.GetAssociatedRole
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetAssociatedRole" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetAssociatedRoleResult getAssociatedRole(GetAssociatedRoleRequest request) {
        request = beforeClientExecution(request);
        return executeGetAssociatedRole(request);
    }

    @SdkInternalApi
    final GetAssociatedRoleResult executeGetAssociatedRole(GetAssociatedRoleRequest getAssociatedRoleRequest) {

        ExecutionContext executionContext = createExecutionContext(getAssociatedRoleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetAssociatedRoleRequest> request = null;
        Response<GetAssociatedRoleResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetAssociatedRoleRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getAssociatedRoleRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetAssociatedRoleResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetAssociatedRoleResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves the connectivity information for a core.
     * 
     * @param getConnectivityInfoRequest
     * @return Result of the GetConnectivityInfo operation returned by the service.
     * @throws BadRequestException
     *         400 response
     * @throws InternalServerErrorException
     *         500 response
     * @sample AWSGreengrass.GetConnectivityInfo
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetConnectivityInfo" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetConnectivityInfoResult getConnectivityInfo(GetConnectivityInfoRequest request) {
        request = beforeClientExecution(request);
        return executeGetConnectivityInfo(request);
    }

    @SdkInternalApi
    final GetConnectivityInfoResult executeGetConnectivityInfo(GetConnectivityInfoRequest getConnectivityInfoRequest) {

        ExecutionContext executionContext = createExecutionContext(getConnectivityInfoRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetConnectivityInfoRequest> request = null;
        Response<GetConnectivityInfoResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetConnectivityInfoRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getConnectivityInfoRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetConnectivityInfoResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetConnectivityInfoResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a core definition version.
     * 
     * @param getCoreDefinitionRequest
     * @return Result of the GetCoreDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetCoreDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetCoreDefinition" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetCoreDefinitionResult getCoreDefinition(GetCoreDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeGetCoreDefinition(request);
    }

    @SdkInternalApi
    final GetCoreDefinitionResult executeGetCoreDefinition(GetCoreDefinitionRequest getCoreDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(getCoreDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCoreDefinitionRequest> request = null;
        Response<GetCoreDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCoreDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getCoreDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetCoreDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetCoreDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a core definition version.
     * 
     * @param getCoreDefinitionVersionRequest
     * @return Result of the GetCoreDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetCoreDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetCoreDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetCoreDefinitionVersionResult getCoreDefinitionVersion(GetCoreDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeGetCoreDefinitionVersion(request);
    }

    @SdkInternalApi
    final GetCoreDefinitionVersionResult executeGetCoreDefinitionVersion(GetCoreDefinitionVersionRequest getCoreDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(getCoreDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCoreDefinitionVersionRequest> request = null;
        Response<GetCoreDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCoreDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getCoreDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetCoreDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetCoreDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Returns the status of a deployment.
     * 
     * @param getDeploymentStatusRequest
     * @return Result of the GetDeploymentStatus operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @sample AWSGreengrass.GetDeploymentStatus
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetDeploymentStatus" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetDeploymentStatusResult getDeploymentStatus(GetDeploymentStatusRequest request) {
        request = beforeClientExecution(request);
        return executeGetDeploymentStatus(request);
    }

    @SdkInternalApi
    final GetDeploymentStatusResult executeGetDeploymentStatus(GetDeploymentStatusRequest getDeploymentStatusRequest) {

        ExecutionContext executionContext = createExecutionContext(getDeploymentStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetDeploymentStatusRequest> request = null;
        Response<GetDeploymentStatusResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetDeploymentStatusRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getDeploymentStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetDeploymentStatusResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetDeploymentStatusResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a device definition.
     * 
     * @param getDeviceDefinitionRequest
     * @return Result of the GetDeviceDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetDeviceDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetDeviceDefinition" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetDeviceDefinitionResult getDeviceDefinition(GetDeviceDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeGetDeviceDefinition(request);
    }

    @SdkInternalApi
    final GetDeviceDefinitionResult executeGetDeviceDefinition(GetDeviceDefinitionRequest getDeviceDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(getDeviceDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetDeviceDefinitionRequest> request = null;
        Response<GetDeviceDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetDeviceDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getDeviceDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetDeviceDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetDeviceDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a device definition version.
     * 
     * @param getDeviceDefinitionVersionRequest
     * @return Result of the GetDeviceDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetDeviceDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetDeviceDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetDeviceDefinitionVersionResult getDeviceDefinitionVersion(GetDeviceDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeGetDeviceDefinitionVersion(request);
    }

    @SdkInternalApi
    final GetDeviceDefinitionVersionResult executeGetDeviceDefinitionVersion(GetDeviceDefinitionVersionRequest getDeviceDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(getDeviceDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetDeviceDefinitionVersionRequest> request = null;
        Response<GetDeviceDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetDeviceDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getDeviceDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetDeviceDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetDeviceDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a Lambda function definition, such as its creation time and latest version.
     * 
     * @param getFunctionDefinitionRequest
     * @return Result of the GetFunctionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetFunctionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetFunctionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetFunctionDefinitionResult getFunctionDefinition(GetFunctionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeGetFunctionDefinition(request);
    }

    @SdkInternalApi
    final GetFunctionDefinitionResult executeGetFunctionDefinition(GetFunctionDefinitionRequest getFunctionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(getFunctionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetFunctionDefinitionRequest> request = null;
        Response<GetFunctionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetFunctionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getFunctionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetFunctionDefinitionResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                            new GetFunctionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a Lambda function definition version, such as which Lambda functions are included in
     * the version and their configurations.
     * 
     * @param getFunctionDefinitionVersionRequest
     * @return Result of the GetFunctionDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetFunctionDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetFunctionDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetFunctionDefinitionVersionResult getFunctionDefinitionVersion(GetFunctionDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeGetFunctionDefinitionVersion(request);
    }

    @SdkInternalApi
    final GetFunctionDefinitionVersionResult executeGetFunctionDefinitionVersion(GetFunctionDefinitionVersionRequest getFunctionDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(getFunctionDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetFunctionDefinitionVersionRequest> request = null;
        Response<GetFunctionDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetFunctionDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getFunctionDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetFunctionDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetFunctionDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a group.
     * 
     * @param getGroupRequest
     * @return Result of the GetGroup operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetGroupResult getGroup(GetGroupRequest request) {
        request = beforeClientExecution(request);
        return executeGetGroup(request);
    }

    @SdkInternalApi
    final GetGroupResult executeGetGroup(GetGroupRequest getGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(getGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetGroupRequest> request = null;
        Response<GetGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetGroupRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetGroupResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                    .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetGroupResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retreives the CA associated with a group. Returns the public key of the CA.
     * 
     * @param getGroupCertificateAuthorityRequest
     * @return Result of the GetGroupCertificateAuthority operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @throws InternalServerErrorException
     *         This request was invalid.
     * @sample AWSGreengrass.GetGroupCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetGroupCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetGroupCertificateAuthorityResult getGroupCertificateAuthority(GetGroupCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeGetGroupCertificateAuthority(request);
    }

    @SdkInternalApi
    final GetGroupCertificateAuthorityResult executeGetGroupCertificateAuthority(GetGroupCertificateAuthorityRequest getGroupCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(getGroupCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetGroupCertificateAuthorityRequest> request = null;
        Response<GetGroupCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetGroupCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getGroupCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetGroupCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetGroupCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves the current configuration for the CA used by the group.
     * 
     * @param getGroupCertificateConfigurationRequest
     * @return Result of the GetGroupCertificateConfiguration operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @throws InternalServerErrorException
     *         This request was invalid.
     * @sample AWSGreengrass.GetGroupCertificateConfiguration
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetGroupCertificateConfiguration"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetGroupCertificateConfigurationResult getGroupCertificateConfiguration(GetGroupCertificateConfigurationRequest request) {
        request = beforeClientExecution(request);
        return executeGetGroupCertificateConfiguration(request);
    }

    @SdkInternalApi
    final GetGroupCertificateConfigurationResult executeGetGroupCertificateConfiguration(
            GetGroupCertificateConfigurationRequest getGroupCertificateConfigurationRequest) {

        ExecutionContext executionContext = createExecutionContext(getGroupCertificateConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetGroupCertificateConfigurationRequest> request = null;
        Response<GetGroupCertificateConfigurationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetGroupCertificateConfigurationRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getGroupCertificateConfigurationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetGroupCertificateConfigurationResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetGroupCertificateConfigurationResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a group version.
     * 
     * @param getGroupVersionRequest
     * @return Result of the GetGroupVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetGroupVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetGroupVersion" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetGroupVersionResult getGroupVersion(GetGroupVersionRequest request) {
        request = beforeClientExecution(request);
        return executeGetGroupVersion(request);
    }

    @SdkInternalApi
    final GetGroupVersionResult executeGetGroupVersion(GetGroupVersionRequest getGroupVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(getGroupVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetGroupVersionRequest> request = null;
        Response<GetGroupVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetGroupVersionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getGroupVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetGroupVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetGroupVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a logger definition.
     * 
     * @param getLoggerDefinitionRequest
     * @return Result of the GetLoggerDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetLoggerDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetLoggerDefinition" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetLoggerDefinitionResult getLoggerDefinition(GetLoggerDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeGetLoggerDefinition(request);
    }

    @SdkInternalApi
    final GetLoggerDefinitionResult executeGetLoggerDefinition(GetLoggerDefinitionRequest getLoggerDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(getLoggerDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetLoggerDefinitionRequest> request = null;
        Response<GetLoggerDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetLoggerDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getLoggerDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetLoggerDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetLoggerDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a logger definition version.
     * 
     * @param getLoggerDefinitionVersionRequest
     * @return Result of the GetLoggerDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetLoggerDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetLoggerDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetLoggerDefinitionVersionResult getLoggerDefinitionVersion(GetLoggerDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeGetLoggerDefinitionVersion(request);
    }

    @SdkInternalApi
    final GetLoggerDefinitionVersionResult executeGetLoggerDefinitionVersion(GetLoggerDefinitionVersionRequest getLoggerDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(getLoggerDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetLoggerDefinitionVersionRequest> request = null;
        Response<GetLoggerDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetLoggerDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getLoggerDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetLoggerDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetLoggerDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves the service role that is attached to the account.
     * 
     * @param getServiceRoleForAccountRequest
     * @return Result of the GetServiceRoleForAccount operation returned by the service.
     * @throws InternalServerErrorException
     *         Server Error
     * @sample AWSGreengrass.GetServiceRoleForAccount
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetServiceRoleForAccount"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetServiceRoleForAccountResult getServiceRoleForAccount(GetServiceRoleForAccountRequest request) {
        request = beforeClientExecution(request);
        return executeGetServiceRoleForAccount(request);
    }

    @SdkInternalApi
    final GetServiceRoleForAccountResult executeGetServiceRoleForAccount(GetServiceRoleForAccountRequest getServiceRoleForAccountRequest) {

        ExecutionContext executionContext = createExecutionContext(getServiceRoleForAccountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetServiceRoleForAccountRequest> request = null;
        Response<GetServiceRoleForAccountResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetServiceRoleForAccountRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getServiceRoleForAccountRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetServiceRoleForAccountResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetServiceRoleForAccountResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a subscription definition.
     * 
     * @param getSubscriptionDefinitionRequest
     * @return Result of the GetSubscriptionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetSubscriptionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetSubscriptionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetSubscriptionDefinitionResult getSubscriptionDefinition(GetSubscriptionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeGetSubscriptionDefinition(request);
    }

    @SdkInternalApi
    final GetSubscriptionDefinitionResult executeGetSubscriptionDefinition(GetSubscriptionDefinitionRequest getSubscriptionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(getSubscriptionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetSubscriptionDefinitionRequest> request = null;
        Response<GetSubscriptionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetSubscriptionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getSubscriptionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetSubscriptionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetSubscriptionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves information about a subscription definition version.
     * 
     * @param getSubscriptionDefinitionVersionRequest
     * @return Result of the GetSubscriptionDefinitionVersion operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.GetSubscriptionDefinitionVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/GetSubscriptionDefinitionVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetSubscriptionDefinitionVersionResult getSubscriptionDefinitionVersion(GetSubscriptionDefinitionVersionRequest request) {
        request = beforeClientExecution(request);
        return executeGetSubscriptionDefinitionVersion(request);
    }

    @SdkInternalApi
    final GetSubscriptionDefinitionVersionResult executeGetSubscriptionDefinitionVersion(
            GetSubscriptionDefinitionVersionRequest getSubscriptionDefinitionVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(getSubscriptionDefinitionVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetSubscriptionDefinitionVersionRequest> request = null;
        Response<GetSubscriptionDefinitionVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetSubscriptionDefinitionVersionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getSubscriptionDefinitionVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetSubscriptionDefinitionVersionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetSubscriptionDefinitionVersionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Lists versions of a core definition.
     * 
     * @param listCoreDefinitionVersionsRequest
     * @return Result of the ListCoreDefinitionVersions operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.ListCoreDefinitionVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListCoreDefinitionVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListCoreDefinitionVersionsResult listCoreDefinitionVersions(ListCoreDefinitionVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeListCoreDefinitionVersions(request);
    }

    @SdkInternalApi
    final ListCoreDefinitionVersionsResult executeListCoreDefinitionVersions(ListCoreDefinitionVersionsRequest listCoreDefinitionVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listCoreDefinitionVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCoreDefinitionVersionsRequest> request = null;
        Response<ListCoreDefinitionVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCoreDefinitionVersionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listCoreDefinitionVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListCoreDefinitionVersionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListCoreDefinitionVersionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves a list of core definitions.
     * 
     * @param listCoreDefinitionsRequest
     * @return Result of the ListCoreDefinitions operation returned by the service.
     * @sample AWSGreengrass.ListCoreDefinitions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListCoreDefinitions" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ListCoreDefinitionsResult listCoreDefinitions(ListCoreDefinitionsRequest request) {
        request = beforeClientExecution(request);
        return executeListCoreDefinitions(request);
    }

    @SdkInternalApi
    final ListCoreDefinitionsResult executeListCoreDefinitions(ListCoreDefinitionsRequest listCoreDefinitionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listCoreDefinitionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCoreDefinitionsRequest> request = null;
        Response<ListCoreDefinitionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCoreDefinitionsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listCoreDefinitionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListCoreDefinitionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListCoreDefinitionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Returns a history of deployments for the group.
     * 
     * @param listDeploymentsRequest
     * @return Result of the ListDeployments operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @sample AWSGreengrass.ListDeployments
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListDeployments" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ListDeploymentsResult listDeployments(ListDeploymentsRequest request) {
        request = beforeClientExecution(request);
        return executeListDeployments(request);
    }

    @SdkInternalApi
    final ListDeploymentsResult executeListDeployments(ListDeploymentsRequest listDeploymentsRequest) {

        ExecutionContext executionContext = createExecutionContext(listDeploymentsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDeploymentsRequest> request = null;
        Response<ListDeploymentsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDeploymentsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listDeploymentsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListDeploymentsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListDeploymentsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Lists the versions of a device definition.
     * 
     * @param listDeviceDefinitionVersionsRequest
     * @return Result of the ListDeviceDefinitionVersions operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.ListDeviceDefinitionVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListDeviceDefinitionVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListDeviceDefinitionVersionsResult listDeviceDefinitionVersions(ListDeviceDefinitionVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeListDeviceDefinitionVersions(request);
    }

    @SdkInternalApi
    final ListDeviceDefinitionVersionsResult executeListDeviceDefinitionVersions(ListDeviceDefinitionVersionsRequest listDeviceDefinitionVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listDeviceDefinitionVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDeviceDefinitionVersionsRequest> request = null;
        Response<ListDeviceDefinitionVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDeviceDefinitionVersionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listDeviceDefinitionVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListDeviceDefinitionVersionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListDeviceDefinitionVersionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves a list of device definitions.
     * 
     * @param listDeviceDefinitionsRequest
     * @return Result of the ListDeviceDefinitions operation returned by the service.
     * @sample AWSGreengrass.ListDeviceDefinitions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListDeviceDefinitions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListDeviceDefinitionsResult listDeviceDefinitions(ListDeviceDefinitionsRequest request) {
        request = beforeClientExecution(request);
        return executeListDeviceDefinitions(request);
    }

    @SdkInternalApi
    final ListDeviceDefinitionsResult executeListDeviceDefinitions(ListDeviceDefinitionsRequest listDeviceDefinitionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listDeviceDefinitionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDeviceDefinitionsRequest> request = null;
        Response<ListDeviceDefinitionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDeviceDefinitionsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listDeviceDefinitionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListDeviceDefinitionsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                            new ListDeviceDefinitionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Lists the versions of a Lambda function definition.
     * 
     * @param listFunctionDefinitionVersionsRequest
     * @return Result of the ListFunctionDefinitionVersions operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.ListFunctionDefinitionVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListFunctionDefinitionVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListFunctionDefinitionVersionsResult listFunctionDefinitionVersions(ListFunctionDefinitionVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeListFunctionDefinitionVersions(request);
    }

    @SdkInternalApi
    final ListFunctionDefinitionVersionsResult executeListFunctionDefinitionVersions(ListFunctionDefinitionVersionsRequest listFunctionDefinitionVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listFunctionDefinitionVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListFunctionDefinitionVersionsRequest> request = null;
        Response<ListFunctionDefinitionVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListFunctionDefinitionVersionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listFunctionDefinitionVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListFunctionDefinitionVersionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListFunctionDefinitionVersionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves a list of Lambda function definitions.
     * 
     * @param listFunctionDefinitionsRequest
     * @return Result of the ListFunctionDefinitions operation returned by the service.
     * @sample AWSGreengrass.ListFunctionDefinitions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListFunctionDefinitions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListFunctionDefinitionsResult listFunctionDefinitions(ListFunctionDefinitionsRequest request) {
        request = beforeClientExecution(request);
        return executeListFunctionDefinitions(request);
    }

    @SdkInternalApi
    final ListFunctionDefinitionsResult executeListFunctionDefinitions(ListFunctionDefinitionsRequest listFunctionDefinitionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listFunctionDefinitionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListFunctionDefinitionsRequest> request = null;
        Response<ListFunctionDefinitionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListFunctionDefinitionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listFunctionDefinitionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListFunctionDefinitionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListFunctionDefinitionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves the current CAs for a group.
     * 
     * @param listGroupCertificateAuthoritiesRequest
     * @return Result of the ListGroupCertificateAuthorities operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @throws InternalServerErrorException
     *         This request was invalid.
     * @sample AWSGreengrass.ListGroupCertificateAuthorities
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListGroupCertificateAuthorities"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListGroupCertificateAuthoritiesResult listGroupCertificateAuthorities(ListGroupCertificateAuthoritiesRequest request) {
        request = beforeClientExecution(request);
        return executeListGroupCertificateAuthorities(request);
    }

    @SdkInternalApi
    final ListGroupCertificateAuthoritiesResult executeListGroupCertificateAuthorities(
            ListGroupCertificateAuthoritiesRequest listGroupCertificateAuthoritiesRequest) {

        ExecutionContext executionContext = createExecutionContext(listGroupCertificateAuthoritiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListGroupCertificateAuthoritiesRequest> request = null;
        Response<ListGroupCertificateAuthoritiesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListGroupCertificateAuthoritiesRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listGroupCertificateAuthoritiesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListGroupCertificateAuthoritiesResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListGroupCertificateAuthoritiesResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * List the versions of a group.
     * 
     * @param listGroupVersionsRequest
     * @return Result of the ListGroupVersions operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.ListGroupVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListGroupVersions" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ListGroupVersionsResult listGroupVersions(ListGroupVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeListGroupVersions(request);
    }

    @SdkInternalApi
    final ListGroupVersionsResult executeListGroupVersions(ListGroupVersionsRequest listGroupVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listGroupVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListGroupVersionsRequest> request = null;
        Response<ListGroupVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListGroupVersionsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listGroupVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListGroupVersionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListGroupVersionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves a list of groups.
     * 
     * @param listGroupsRequest
     * @return Result of the ListGroups operation returned by the service.
     * @sample AWSGreengrass.ListGroups
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListGroups" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ListGroupsResult listGroups(ListGroupsRequest request) {
        request = beforeClientExecution(request);
        return executeListGroups(request);
    }

    @SdkInternalApi
    final ListGroupsResult executeListGroups(ListGroupsRequest listGroupsRequest) {

        ExecutionContext executionContext = createExecutionContext(listGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListGroupsRequest> request = null;
        Response<ListGroupsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListGroupsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listGroupsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListGroupsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                    .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListGroupsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Lists the versions of a logger definition.
     * 
     * @param listLoggerDefinitionVersionsRequest
     * @return Result of the ListLoggerDefinitionVersions operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.ListLoggerDefinitionVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListLoggerDefinitionVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListLoggerDefinitionVersionsResult listLoggerDefinitionVersions(ListLoggerDefinitionVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeListLoggerDefinitionVersions(request);
    }

    @SdkInternalApi
    final ListLoggerDefinitionVersionsResult executeListLoggerDefinitionVersions(ListLoggerDefinitionVersionsRequest listLoggerDefinitionVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listLoggerDefinitionVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListLoggerDefinitionVersionsRequest> request = null;
        Response<ListLoggerDefinitionVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListLoggerDefinitionVersionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listLoggerDefinitionVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListLoggerDefinitionVersionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListLoggerDefinitionVersionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves a list of logger definitions.
     * 
     * @param listLoggerDefinitionsRequest
     * @return Result of the ListLoggerDefinitions operation returned by the service.
     * @sample AWSGreengrass.ListLoggerDefinitions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListLoggerDefinitions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListLoggerDefinitionsResult listLoggerDefinitions(ListLoggerDefinitionsRequest request) {
        request = beforeClientExecution(request);
        return executeListLoggerDefinitions(request);
    }

    @SdkInternalApi
    final ListLoggerDefinitionsResult executeListLoggerDefinitions(ListLoggerDefinitionsRequest listLoggerDefinitionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listLoggerDefinitionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListLoggerDefinitionsRequest> request = null;
        Response<ListLoggerDefinitionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListLoggerDefinitionsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listLoggerDefinitionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListLoggerDefinitionsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                            new ListLoggerDefinitionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Lists the versions of a subscription definition.
     * 
     * @param listSubscriptionDefinitionVersionsRequest
     * @return Result of the ListSubscriptionDefinitionVersions operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.ListSubscriptionDefinitionVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListSubscriptionDefinitionVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListSubscriptionDefinitionVersionsResult listSubscriptionDefinitionVersions(ListSubscriptionDefinitionVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeListSubscriptionDefinitionVersions(request);
    }

    @SdkInternalApi
    final ListSubscriptionDefinitionVersionsResult executeListSubscriptionDefinitionVersions(
            ListSubscriptionDefinitionVersionsRequest listSubscriptionDefinitionVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listSubscriptionDefinitionVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListSubscriptionDefinitionVersionsRequest> request = null;
        Response<ListSubscriptionDefinitionVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListSubscriptionDefinitionVersionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listSubscriptionDefinitionVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListSubscriptionDefinitionVersionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListSubscriptionDefinitionVersionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Retrieves a list of subscription definitions.
     * 
     * @param listSubscriptionDefinitionsRequest
     * @return Result of the ListSubscriptionDefinitions operation returned by the service.
     * @sample AWSGreengrass.ListSubscriptionDefinitions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListSubscriptionDefinitions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListSubscriptionDefinitionsResult listSubscriptionDefinitions(ListSubscriptionDefinitionsRequest request) {
        request = beforeClientExecution(request);
        return executeListSubscriptionDefinitions(request);
    }

    @SdkInternalApi
    final ListSubscriptionDefinitionsResult executeListSubscriptionDefinitions(ListSubscriptionDefinitionsRequest listSubscriptionDefinitionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listSubscriptionDefinitionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListSubscriptionDefinitionsRequest> request = null;
        Response<ListSubscriptionDefinitionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListSubscriptionDefinitionsRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listSubscriptionDefinitionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListSubscriptionDefinitionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListSubscriptionDefinitionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Resets a group's deployments.
     * 
     * @param resetDeploymentsRequest
     *        Information needed to perform a reset of a group's deployments.
     * @return Result of the ResetDeployments operation returned by the service.
     * @throws BadRequestException
     *         invalid request
     * @sample AWSGreengrass.ResetDeployments
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ResetDeployments" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ResetDeploymentsResult resetDeployments(ResetDeploymentsRequest request) {
        request = beforeClientExecution(request);
        return executeResetDeployments(request);
    }

    @SdkInternalApi
    final ResetDeploymentsResult executeResetDeployments(ResetDeploymentsRequest resetDeploymentsRequest) {

        ExecutionContext executionContext = createExecutionContext(resetDeploymentsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ResetDeploymentsRequest> request = null;
        Response<ResetDeploymentsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ResetDeploymentsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(resetDeploymentsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ResetDeploymentsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ResetDeploymentsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates the connectivity information for the core. Any devices that belong to the group which has this core will
     * receive this information in order to find the location of the core and connect to it.
     * 
     * @param updateConnectivityInfoRequest
     *        connectivity info request
     * @return Result of the UpdateConnectivityInfo operation returned by the service.
     * @throws BadRequestException
     *         400 response
     * @throws InternalServerErrorException
     *         500 response
     * @sample AWSGreengrass.UpdateConnectivityInfo
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateConnectivityInfo"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateConnectivityInfoResult updateConnectivityInfo(UpdateConnectivityInfoRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateConnectivityInfo(request);
    }

    @SdkInternalApi
    final UpdateConnectivityInfoResult executeUpdateConnectivityInfo(UpdateConnectivityInfoRequest updateConnectivityInfoRequest) {

        ExecutionContext executionContext = createExecutionContext(updateConnectivityInfoRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateConnectivityInfoRequest> request = null;
        Response<UpdateConnectivityInfoResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateConnectivityInfoRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(updateConnectivityInfoRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateConnectivityInfoResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateConnectivityInfoResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates a core definition.
     * 
     * @param updateCoreDefinitionRequest
     * @return Result of the UpdateCoreDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.UpdateCoreDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateCoreDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateCoreDefinitionResult updateCoreDefinition(UpdateCoreDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateCoreDefinition(request);
    }

    @SdkInternalApi
    final UpdateCoreDefinitionResult executeUpdateCoreDefinition(UpdateCoreDefinitionRequest updateCoreDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(updateCoreDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateCoreDefinitionRequest> request = null;
        Response<UpdateCoreDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateCoreDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(updateCoreDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateCoreDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateCoreDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates a device definition.
     * 
     * @param updateDeviceDefinitionRequest
     * @return Result of the UpdateDeviceDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.UpdateDeviceDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateDeviceDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateDeviceDefinitionResult updateDeviceDefinition(UpdateDeviceDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateDeviceDefinition(request);
    }

    @SdkInternalApi
    final UpdateDeviceDefinitionResult executeUpdateDeviceDefinition(UpdateDeviceDefinitionRequest updateDeviceDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(updateDeviceDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateDeviceDefinitionRequest> request = null;
        Response<UpdateDeviceDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateDeviceDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(updateDeviceDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateDeviceDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateDeviceDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates a Lambda function definition.
     * 
     * @param updateFunctionDefinitionRequest
     * @return Result of the UpdateFunctionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.UpdateFunctionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateFunctionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateFunctionDefinitionResult updateFunctionDefinition(UpdateFunctionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateFunctionDefinition(request);
    }

    @SdkInternalApi
    final UpdateFunctionDefinitionResult executeUpdateFunctionDefinition(UpdateFunctionDefinitionRequest updateFunctionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(updateFunctionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateFunctionDefinitionRequest> request = null;
        Response<UpdateFunctionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateFunctionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(updateFunctionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateFunctionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateFunctionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates a group.
     * 
     * @param updateGroupRequest
     * @return Result of the UpdateGroup operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.UpdateGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public UpdateGroupResult updateGroup(UpdateGroupRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateGroup(request);
    }

    @SdkInternalApi
    final UpdateGroupResult executeUpdateGroup(UpdateGroupRequest updateGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(updateGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateGroupRequest> request = null;
        Response<UpdateGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateGroupRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(updateGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateGroupResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateGroupResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates the Cert expiry time for a group.
     * 
     * @param updateGroupCertificateConfigurationRequest
     * @return Result of the UpdateGroupCertificateConfiguration operation returned by the service.
     * @throws BadRequestException
     *         This request was invalid.
     * @throws InternalServerErrorException
     *         This request was invalid.
     * @sample AWSGreengrass.UpdateGroupCertificateConfiguration
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateGroupCertificateConfiguration"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateGroupCertificateConfigurationResult updateGroupCertificateConfiguration(UpdateGroupCertificateConfigurationRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateGroupCertificateConfiguration(request);
    }

    @SdkInternalApi
    final UpdateGroupCertificateConfigurationResult executeUpdateGroupCertificateConfiguration(
            UpdateGroupCertificateConfigurationRequest updateGroupCertificateConfigurationRequest) {

        ExecutionContext executionContext = createExecutionContext(updateGroupCertificateConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateGroupCertificateConfigurationRequest> request = null;
        Response<UpdateGroupCertificateConfigurationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateGroupCertificateConfigurationRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(updateGroupCertificateConfigurationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateGroupCertificateConfigurationResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateGroupCertificateConfigurationResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates a logger definition.
     * 
     * @param updateLoggerDefinitionRequest
     * @return Result of the UpdateLoggerDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.UpdateLoggerDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateLoggerDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateLoggerDefinitionResult updateLoggerDefinition(UpdateLoggerDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateLoggerDefinition(request);
    }

    @SdkInternalApi
    final UpdateLoggerDefinitionResult executeUpdateLoggerDefinition(UpdateLoggerDefinitionRequest updateLoggerDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(updateLoggerDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateLoggerDefinitionRequest> request = null;
        Response<UpdateLoggerDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateLoggerDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(updateLoggerDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateLoggerDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateLoggerDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Updates a subscription definition.
     * 
     * @param updateSubscriptionDefinitionRequest
     * @return Result of the UpdateSubscriptionDefinition operation returned by the service.
     * @throws BadRequestException
     *         user error
     * @sample AWSGreengrass.UpdateSubscriptionDefinition
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/UpdateSubscriptionDefinition"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateSubscriptionDefinitionResult updateSubscriptionDefinition(UpdateSubscriptionDefinitionRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateSubscriptionDefinition(request);
    }

    @SdkInternalApi
    final UpdateSubscriptionDefinitionResult executeUpdateSubscriptionDefinition(UpdateSubscriptionDefinitionRequest updateSubscriptionDefinitionRequest) {

        ExecutionContext executionContext = createExecutionContext(updateSubscriptionDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateSubscriptionDefinitionRequest> request = null;
        Response<UpdateSubscriptionDefinitionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateSubscriptionDefinitionRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(updateSubscriptionDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateSubscriptionDefinitionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateSubscriptionDefinitionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for debugging issues
     * where a service isn't acting as expected. This data isn't considered part of the result data returned by an
     * operation, so it's available through this separate, diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access this extra diagnostic
     * information for an executed request, you should use this method to retrieve it as soon as possible after
     * executing the request.
     *
     * @param request
     *        The originally executed request
     *
     * @return The response metadata for the specified request, or null if none is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    /**
     * Normal invoke with authentication. Credentials are required and may be overriden at the request level.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {

        executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));

        return doInvoke(request, responseHandler, executionContext);
    }

    /**
     * Invoke with no authentication. Credentials are not required and any credentials set on the client or request will
     * be ignored for this operation.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext) {

        return doInvoke(request, responseHandler, executionContext);
    }

    /**
     * Invoke the request using the http client. Assumes credentials (or lack thereof) have been configured in the
     * ExecutionContext beforehand.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata());

        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }

}