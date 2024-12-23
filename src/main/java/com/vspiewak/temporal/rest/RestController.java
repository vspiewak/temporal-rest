package com.vspiewak.temporal.rest;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.api.workflowservice.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.temporal.client.WorkflowClient;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/")
public class RestController {

    @Autowired
    WorkflowClient client;

    @GetMapping("/system-info")
    ResponseEntity<GetSystemInfoResponse> getSystemInfo() {

        var response = client.getWorkflowServiceStubs().blockingStub().getSystemInfo(GetSystemInfoRequest.newBuilder().build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/cluster")
    ResponseEntity<GetClusterInfoResponse> getClusterInfo() {

        var response = client.getWorkflowServiceStubs().blockingStub().getClusterInfo(GetClusterInfoRequest.newBuilder().build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/cluster/namespaces")
    ResponseEntity<ListNamespacesResponse> listNamespaces() {

        var response = client.getWorkflowServiceStubs().blockingStub().listNamespaces(ListNamespacesRequest.newBuilder().build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/cluster/namespaces/{namespace}")
    ResponseEntity<DescribeNamespaceResponse> describeNamespace(@PathVariable String namespace) {

        var response = client.getWorkflowServiceStubs().blockingStub().describeNamespace(DescribeNamespaceRequest.newBuilder().setNamespace(namespace).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/archived-workflows")
    ResponseEntity<ListArchivedWorkflowExecutionsResponse> listArchivedWorkflowExecutions(@PathVariable String namespace) {

        var response = client.getWorkflowServiceStubs().blockingStub().listArchivedWorkflowExecutions(ListArchivedWorkflowExecutionsRequest.newBuilder().setNamespace(namespace).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/batch-operations")
    ResponseEntity<ListBatchOperationsResponse> listBatchOperations(@PathVariable String namespace) {

        var response = client.getWorkflowServiceStubs().blockingStub().listBatchOperations(ListBatchOperationsRequest.newBuilder().setNamespace(namespace).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/batch-operations/{jobId}")
    ResponseEntity<DescribeBatchOperationResponse> describeBatchOperation(@PathVariable String namespace, @PathVariable String jobId) {

        var response = client.getWorkflowServiceStubs().blockingStub().describeBatchOperation(DescribeBatchOperationRequest.newBuilder().setNamespace(namespace).setJobId(jobId).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/schedules")
    ResponseEntity<ListSchedulesResponse> listSchedules(@PathVariable String namespace, @RequestParam(required = false, defaultValue = "") String query) {

        var response = client.getWorkflowServiceStubs().blockingStub().listSchedules(ListSchedulesRequest.newBuilder().setNamespace(namespace).setQuery(query).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/schedules/{scheduleId}")
    ResponseEntity<DescribeScheduleResponse> describeSchedule(@PathVariable String namespace, @PathVariable String scheduleId) {

        var response = client.getWorkflowServiceStubs().blockingStub().describeSchedule(DescribeScheduleRequest.newBuilder().setNamespace(namespace).setScheduleId(scheduleId).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //FIXME
    @GetMapping("/namespaces/{namespace}/schedules/{scheduleId}/matching-times")
    ResponseEntity<ListScheduleMatchingTimesResponse> listScheduleMatchingTimes(@PathVariable String namespace, @PathVariable String scheduleId) {

        var response = client.getWorkflowServiceStubs().blockingStub().listScheduleMatchingTimes(ListScheduleMatchingTimesRequest.newBuilder().setNamespace(namespace).setScheduleId(scheduleId).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //TODO /namespaces/{namespace}/task-queues/{taskQueue}/worker-build-id-compatibility

    //TODO /namespaces/{namespace}/task-queues/{taskQueue}/worker-versioning-rules

    //TODO /namespaces/{namespace}/task-queues/{task_queue.name}

    //TODO /namespaces/{namespace}/worker-task-reachability

    @GetMapping("/namespaces/{namespace}/workflow-count")
    ResponseEntity<CountWorkflowExecutionsResponse> countWorkflowExecutions(@PathVariable String namespace) {

        var response = client.getWorkflowServiceStubs().blockingStub().countWorkflowExecutions(CountWorkflowExecutionsRequest.newBuilder().setNamespace(namespace).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/workflows")
    ResponseEntity<ListWorkflowExecutionsResponse> listWorkflowExecutions(@PathVariable String namespace) {

        var response = client.getWorkflowServiceStubs().blockingStub().listWorkflowExecutions(ListWorkflowExecutionsRequest.newBuilder().setNamespace(namespace).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/workflows/{workflowId}")
    ResponseEntity<DescribeWorkflowExecutionResponse> describeWorkflowExecution(@PathVariable String namespace, @PathVariable String workflowId, @RequestParam(required = false, defaultValue = "") String runId) {

        var response = client.getWorkflowServiceStubs().blockingStub().describeWorkflowExecution(DescribeWorkflowExecutionRequest.newBuilder().setNamespace(namespace).setExecution(WorkflowExecution.newBuilder().setWorkflowId(workflowId).setRunId(runId).build()).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/workflows/{workflowId}/history")
    ResponseEntity<GetWorkflowExecutionHistoryResponse> getWorkflowExecutionHistory(@PathVariable String namespace, @PathVariable String workflowId, @RequestParam(required = false, defaultValue = "") String runId) {

        var response = client.getWorkflowServiceStubs().blockingStub().getWorkflowExecutionHistory(GetWorkflowExecutionHistoryRequest.newBuilder().setNamespace(namespace).setExecution(WorkflowExecution.newBuilder().setWorkflowId(workflowId).setRunId(runId).build()).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/namespaces/{namespace}/workflows/{workflowId}/history-reverse")
    ResponseEntity<GetWorkflowExecutionHistoryReverseResponse> getWorkflowExecutionHistoryReverse(@PathVariable String namespace, @PathVariable String workflowId, @RequestParam(required = false, defaultValue = "") String runId) {

        var response = client.getWorkflowServiceStubs().blockingStub().getWorkflowExecutionHistoryReverse(GetWorkflowExecutionHistoryReverseRequest.newBuilder().setNamespace(namespace).setExecution(WorkflowExecution.newBuilder().setWorkflowId(workflowId).setRunId(runId).build()).build());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}