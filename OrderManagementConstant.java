package com.worksap.company.hue.scm.bizcore.procurement.service.ordermanagement.constant;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;

/**
 * OrderManagementConstant Class is used to declare the constants.
 *
 * @author Subbiah.S
 * @since HUE 17.03
 *
 */

/** The Constant log. */
@Slf4j
public class OrderManagementConstant {
    /** The Constant DASHBOARD_ID. */
    public static final String DASHBOARD_ID = "dashboard-sidemenu-menu-list-simple-content";
    /** The Constant PROCUREMENT_REQUEST_ID. */
    public static final String PROCUREMENT_REQUEST_ID = "procurement-request-sidemenu-menu-list-accordion-content";
    /** The Constant APPLY_FOR_ORDER_ID. */
    public static final String APPLY_FOR_ORDER_ID = "applying-for-order-sidemenu-menu-list-accordion-content";
    /** The Constant WAIT_FOR_ISSUANCE_ORDER_ID. */
    public static final String WAIT_FOR_ISSUANCE_ORDER_ID = "wait-forissuance-oforder-sidemenu-menu-list-accordion-content";
    /** The Constant PENDING_ORDER_ID. */
    public static final String PENDING_ORDER_ID = "pending-orders-pending-sidemenu-menu-list-accordion-content";
    /** The Constant WAITING_FOR_DELIVERY_ID. */
    public static final String WAITING_FOR_DELIVERY_ID = "waiting-fordelivery-sidemenu-menu-list-accordion-content";
    /** The Constant PENDING_PROVISIONAL_ID. */
    public static final String PENDING_PROVISIONAL_ID = "pending-provisional-orders-pending-sidemenu-menu-list-accordion-content";
    /** The Constant DASHBOARD_ACCORDION_ID. */
    public static final String DASHBOARD_ACCORDION_ID = "dashboard-content-list-accordion";
    /** The Constant COLLECTIVE_ORDER_ID. */
    public static final String COLLECTIVE_ORDER_ID = "collective-order-sidemenu-menu-list-accordion-content";
    /** The Constant BARCODE_ID. */
    public static final String BARCODE_ID = "barcode-sidemenu-menu-list-accordion";
    /** The Constant FIND_ORDERING_CASES_ID. */
    public static final String FIND_ORDERING_CASES_ID = "find-ordering-cases-sidemenu-menu-list-simple-content";

    /** id for order search view with angular. instead of FIND_ORDERING_CASES_ID, this screen will be used from 18.12 */
    public static final String SEARCH_ORDER_CASES_ID = "search-order-cases";

    /**
     * id for order detail search view with angular. instead of FIND_ORDERING_CASES_ID, this screen will be used from
     * 18.12
     */
    public static final String SEARCH_ORDER_DETAIL_CASES_ID = "search-order-detail-cases";

    /** The Constant REQUEST_DATE. */
    public static final String REQUEST_DATE = "PC.POMT.dateRequest";
    /** The Constant DELIVERY_DATE. */
    public static final String DELIVERY_DATE = "PC.POMT.deliveryDate";
    /** The Constant SEE_MORE. */
    public static final String SEE_MORE = "PC.POMT.seeMore";
    /** The Constant APPLICATION_DATE. */
    public static final String APPLICATION_DATE = "PC.POMT.applicationDate";
    /** The Constant RETENTION_DATE. */
    public static final String RETENTION_DATE = "PC.POMT.retentionDate";
    /** The Constant ORDER_DATE. */
    public static final String ORDER_DATE = "PC.POMT.purchaseOrderDate";
    /** The Constant SAVED_DATE. */
    public static final String SAVED_DATE = "PC.POMT.SavedDate";
    /** The Constant SEND_EMAIL. */
    public static final String SEND_EMAIL = "PC.POMT.sendEmail";

    /** The Constant ORDER_STATUS_TEXT_INPUT. */
    public static final String ORDER_STATUS_TEXT_INPUT = "order-status-text-input";

    /** The Constant ACCEPTED. */
    public static final String ACCEPTED = "PC.POMT.accepted";

    /** The Constant WAITING_FOR_ORDER_CONFIRMATION. */
    public static final String WAITING_FOR_ORDER_CONFIRMATION = "WAITING_FOR_ORDER_CONFIRMATION";

    /** The Constant WAITING_FOR_ORDER_CONFIRMATION. */
    public static final String WAITING_FOR_CANCEL_ORDER_SHEET_PRINTING = "WAITING_FOR_CANCEL_ORDER_SHEET_PRINTING";

    /** The Constant orderStatus WAITING_FOR_ORDER_MATCHING. */
    public static final String WAITING_FOR_ORDER_MATCHING = "WAITING_FOR_ORDER_MATCHING";

    /** The Constant orderStatus ORDER_MATCHING_COMPLETED. */
    public static final String ORDER_MATCHING_COMPLETED = "ORDER_MATCHING_COMPLETED";

    /** The Constant orderStatus WAITING_FOR_PROGRESS_BASED_INSPECTION. */
    public static final String WAITING_FOR_PROGRESS_BASED_INSPECTION = "WAITING_FOR_PROGRESS_BASED_INSPECTION";

    /** The Constant orderStatus CONSTRUCTION_COMPLETED. */
    public static final String CONSTRUCTION_COMPLETED = "CONSTRUCTION_COMPLETED";

    /** The Constant orderStatus PROGRESS_BASED_INSPECTING. */
    public static final String PROGRESS_BASED_INSPECTING = "PROGRESS_BASED_INSPECTING";

    /** The Constant DYNAMIC_DASHBOARD. */
    public static final String DYNAMIC_DASHBOARD = "PC.POMT.dashboard";

    /** The Constant DYNAMIC_PROCEEDINGS_PROGRESS. */
    public static final String DYNAMIC_PROCEEDINGS_PROGRESS = "PC.POMT.proceedingsInProgress";

    /** The Constant DYNAMIC_PROCUREMENT_REQUEST. */
    public static final String DYNAMIC_PROCUREMENT_REQUEST = "PC.POMT.procurementRequest";

    /** The Constant DYNAMIC_APPLYING_ORDER. */
    public static final String DYNAMIC_APPLYING_ORDER = "PC.POMT.applyingForOrder";

    /** The Constant DYNAMIC_WAIT_ISSUANCE. */
    public static final String DYNAMIC_WAIT_ISSUANCE = "PC.POMT.waitForIssuanceOrder";

    /** The Constant DYNAMIC_PENDING_ORDER. */
    public static final String DYNAMIC_PENDING_ORDER = "PC.POMT.pendingOrdersPending";

    /** The Constant DYNAMIC_PENDING_ORDER. */
    public static final String DYNAMIC_PENDING_PROVISIONAL_ORDER = "PC.POMT.pendingProvisionalOrdersPending";

    /** The Constant DYNAMIC_WAIT_DELIVERY. */
    public static final String DYNAMIC_WAIT_DELIVERY = "PC.POMT.waitForDelivery";

    /** The Constant DYNAMIC_BARCODE_PROCESSING. */
    public static final String DYNAMIC_BARCODE_PROCESSING = "PC.POMT.barCodeProcessing";

    /** The Constant DYNAMIC_BARCODE_PROCESSING. */
    public static final String DYNAMIC_COLLECTIVE_ORDER = "PC.POMT.collectiveOrder";

    /** The Constant DYNAMIC_BARCODE_PROCESSING. */
    public static final String DYNAMIC_FIND_ORDER = "PC.POMT.findOrderingCases";

    /** The text id for order search view with angular. instead of DYNAMIC_FIND_ORDER, this will be used from 18.12 */
    public static final String SEARCH_ORDER_CASES_TEXT_ID = "PC.POMT.findOrderingCases";

    /**
     * The text id for order detail search view with angular. instead of DYNAMIC_FIND_ORDER, this will be used from
     * 18.12
     */
    public static final String SEARCH_ORDER_DETAIL_CASES_TEXT_ID = "pp.name.findOrderingDetailCases";

    /** The Constant SPECIAL. */
    public static final String SPECIAL = "SPECIAL";

    /** The Constant GENERAL. */
    public static final String GENERAL = "GENERAL";

    /** The Constant SERVICE. */
    public static final String SERVICE = "SERVICE";

    /** The Constant LEASE_AND_RENTAL. */
    public static final String LEASE_AND_RENTAL = "LEASE_AND_RENTAL";

    /** The Constant LICENSE. */
    public static final String LICENSE = "LICENSE";

    /** The Constant RAW_MATERIALS. */
    public static final String RAW_MATERIALS = "RAW_MATERIALS";

    /** The Constant FROM_STOCK. */
    public static final String FROM_STOCK = "FROM_STOCK";

    /** The Constant WAITING_FOR_DELIVERY. */
    public static final String WAITING_FOR_DELIVERY = "PC.POMT.waitingForDelivery";

    /** The Constant MAKE_ITANORDER_ACCEPTED. */
    public static final String MAKE_ITANORDER_ACCEPTED = "Make_itanorder_accepted";

    /** The Constant TYPE. */
    public static final String TYPE = "type";

    /** The Constant CORP_CODE. */
    public static final String CORP_CODE = "corporationCode";

    /** The Constant DTO_USER_ID. */
    public static final String DTO_USER_ID = "userId";

    /** The Constant COLLECTIVE_ORDER_LIST. */
    public static final String COLLECTIVE_ORDER_LIST = "collective-order-inbox-list";

    /** The Constant WAP_ICON_FILE. */
    public static final String WAP_ICON_FILE = "wap-icon-file";

    /** The Constant WAP_ICON_PENCIL. */
    public static final String WAP_ICON_PENCIL = "wap-icon-pencil";

    /** The Constant WAP_ICON_LIST. */
    public static final String WAP_ICON_LIST = "wap-icon-list";

    /** The Constant ORDER_PROCUREMENT_LIST. */
    public static final String ORDER_PROCUREMENT_LIST = "order-portal-procurement-inbox-list";

    /** The Constant SEARCH_STATS_LABEL. */
    public static final String SEARCH_STATS_LABEL = "search-stats-label";

    /** The Constant ORDER_REMAND_LIST. */
    public static final String ORDER_REMAND_LIST = "order-remand-inbox-list";

    /** The Constant TEMPORARY_SAVE. */
    public static final String TEMPORARY_SAVE = "TEMPORARY_SAVE";

    /** The Constant USER_ID. */
    public static final String USER_ID = "user_id";

    /** The Constant ID_VALUE. */
    public static final String ID_VALUE = "abc5a3c4-587f-4f54-b6a4-7c1510e839a9";

    /** The Constant REQUESTING. */
    public static final String REQUESTING = "REQUESTING";

    /** The Constant REMAND_STATS_LABEL. */
    public static final String REMAND_STATS_LABEL = "remand-stats-label";

    /** The Constant ORDER_TEMPORARY_SAVE_INBOX_LIST. */
    public static final String ORDER_TEMPORARY_SAVE_INBOX_LIST = "order-temporary-save-inbox-list";

    /** The Constant TEMPORARY_SAVE_STATS_LABEL. */
    public static final String TEMPORARY_SAVE_STATS_LABEL = "temporary-save-stats-label";

    /** The Constant APPLYING_EXPAND_LIST. */
    public static final String APPLYING_EXPAND_LIST = "order-applying-expand-inbox-list";

    /** The Constant APPLYING_INBOX_LIST. */
    public static final String APPLYING_INBOX_LIST = "order-applying-inbox-list";

    /** The Constant APPLYING_STATS_LABEL. */
    public static final String APPLYING_STATS_LABEL = "applying-stats-label";

    /** The Constant WAIT_ISSUANCE_INBOX_LIST. */
    public static final String WAIT_ISSUANCE_INBOX_LIST = "wait-issuance-inbox-list";

    /** The Constant USER_SEGMENT_VALUE. */
    public static final String USER_SEGMENT_VALUE = "userSegmentValue";

    /** The Constant SWITCH_TO_VENDOR_LIST. */
    public static final String SWITCH_TO_VENDOR_LIST = "switch-to-vendor-inbox-list";

    /** The Constant TRUE. */
    public static final String TRUE = "true";

    /** The Constant FALSE. */
    public static final String FALSE = "false";

    /** The Constant PENDING_STATS_LABEL. */
    public static final String PENDING_STATS_LABEL = "pending-stats-label";

    /** The Constant PENDING_INBOX_LIST. */
    public static final String PENDING_INBOX_LIST = "order-pending-inbox-list";

    /** The Constant WAIT_DELIVERY_INBOX_LIST. */
    public static final String WAIT_DELIVERY_INBOX_LIST = "order-wait-delivery-inbox-list";

    /** The Constant WAIT_DELIVERY_STATS_LABEL. */
    public static final String WAIT_DELIVERY_STATS_LABEL = "wait-delivery-stats-label";

    /** The Constant DASHBOARD_INBOX_LIST. */
    public static final String DASHBOARD_INBOX_LIST = "order-dashboard-inbox-list";

    /** The Constant DASHBOARD_EXPAND_INBOX_LIST. */
    public static final String DASHBOARD_EXPAND_INBOX_LIST = "order-dashboard-expand-inbox-list";

    /** The Constant CONFIRM_EXPAND_INBOX_LIST. */
    public static final String CONFIRM_EXPAND_INBOX_LIST = "order-confirm-expand-inbox-list";

    /** The Constant APPLYING_ORDER_NOT_SHOW. */
    public static final String APPLYING_ORDER_NOT_SHOW = "APPLYING_ORDER";

    /** The Constant ISSUANCE_OF_ORDER_NOT_SHOW. */
    public static final String ISSUANCE_OF_ORDER_NOT_SHOW = "ISSUANCE_OF_ORDER";

    /** The Constant PENDING_ORDER_NOT_SHOW. */
    public static final String PENDING_ORDER_NOT_SHOW = "PENDING_ORDER";

    /** The Constant WAITING_FOR_DELIVERYNOT_SHOW. */
    public static final String WAITING_FOR_DELIVERYNOT_SHOW = "WAITING_FOR_DELIVERY";

    /** The Constant PENDING_PROVISIONAL_ORDER. */
    public static final String PENDING_PROVISIONAL_ORDER = "PENDING_PROVISIONAL_ORDER";

    /** The Constant WARNING. */
    public static final String WARNING = "WARNING";

    /** The Constant ORDER_REGISTRATION_SID. */
    public static final String ORDER_REGISTRATION_SID = "ScmProcurementPurchaseOrderApplication.OrderRegistration";

    /** The Constant ORDER_MODIFICATION_REMANDED_ID. */
    public static final String ORDER_MODIFICATION_REMANDED_ID = "ORDER_MODIFICATION_REMANDED";

    /** The Constant ORDER_ORDER_CONFIRMATION_REJECTED_ID. */
    public static final String ORDER_ORDER_CONFIRMATION_REJECTED_ID = "ORDER_ORDER_CONFIRMATION_REJECTED";

    /** The Constant ORDER_REMANDED_ID. */
    public static final String ORDER_REMANDED_ID = "ORDER_REMANDED";

    /** The Constant ORDERING_REMANDED_ID. */
    public static final String ORDERING_REMANDED_ID = "ORDERING_REMANDED";

    /** The Constant METHOD_STARTS. */
    public static final String METHOD_STARTS = "method starts";

    /** The Constant METHOD_ENDS. */
    public static final String METHOD_ENDS = "method ends";

    /** The Constant COLON. */
    public static final String COLON = ":";

    /** The Constant URL_START_SID. */
    public static final String URL_START_SID = "/start?sid=";

    /** The Constant MODULUS_THREE. */
    public static final int MODULUS_THREE = 3;

    /** The Constant NEGATIVE_NUMERIC. */
    public static final int NEGATIVE_NUMERIC = -1;

    /** The Constant WAITING_FOR_PRINT. */
    public static final String WAITING_FOR_PRINT = "WAITING_FOR_PRINT";

    /** The Constant DRAFT. */
    public static final String DRAFT = "PC.POMT.Draft";

    /** The Constant ORDER_REQUEST. */
    public static final String ORDER_REQUEST = "ORDER_REQUEST";

    /** The Constant MODIFICATION_REQUEST. */
    public static final String MODIFICATION_REQUEST = "MODIFICATION_REQUEST";

    /** The Constant MODIFICATION_ON_REQUEST. */
    public static final String MODIFICATION_ON_REQUEST = "MODIFICATION_ON_REQUEST";

    /** The Constant NOT_ASSIGNED. */
    public static final String NOT_ASSIGNED = "NOT_ASSIGNED";

    /** The Constant NOT_ASSIGNED TEXT ID */
    public static final String NOT_ASSIGNED_TEXT_ID = "PC.POMT.notAssigned";

    /** The Constant EMPTY TITLE TEXT ID */
    public static final String EMPTY_TITLE_TEXT_ID = "PC.POMT.emptyTitle";

    /** The Constant REMANDED. */
    public static final String REMANDED = "REMANDED";

    /** The Constant MENU_COLOR_LIST. */
    public static final ImmutableList<String> MENU_COLOR_LIST = ImmutableList.of("lightblue", "orange", "green");

    /** The Constant TEMPORARY_SAVING. */
    public static final String TEMPORARY_SAVING = "TEMPORARY_SAVING";

    /** The Constant WAITING_FOR_ORDERSHEET_PRINTING. */
    public static final String WAITING_FOR_ORDERSHEET_PRINTING = "WAITING_FOR_ORDER_SHEET_PRINTING";

    /** The Constant WAITING_FOR_ORDER_CONFIRMATION_DELAYED. */
    public static final String WAITING_FOR_ORDER_CONFIRMATION_DELAYED = "WAITING_FOR_ORDER_CONFIRMATION_DELAYED";

    /** The Constant WAITING_FOR_ORDER_CONFIRMATION_INPUT. */
    public static final String WAITING_FOR_ORDER_CONFIRMATION_INPUT = "WAITING_FOR_ORDER_CONFIRMATION_INPUT";

    /** The Constant WAITING_FOR_ATP_ANSWER_DELAYED. */
    public static final String WAITING_FOR_ATP_ANSWER_DELAYED = "WAITING_FOR_ATP_ANSWER_DELAYED";

    /** The Constant WAITING_FOR_ATP_ANSWER_INPUT. */
    public static final String WAITING_FOR_ATP_ANSWER_INPUT = "WAITING_FOR_ATP_ANSWER_INPUT";

    /** The Constant orderType of IN_ACCEPTANCE. */
    public static final String IN_ACCEPTANCE = "IN_ACCEPTANCE";

    /** The Constant orderType of IN_ORDER_MATCHING. */
    public static final String IN_ORDER_MATCHING = "IN_ORDER_MATCHING";

    /** The Constant orderType of IN_PROGRESS_BASED_INSPECTION. */
    public static final String IN_PROGRESS_BASED_INSPECTION = "IN_PROGRESS_BASED_INSPECTION";

    /** The Constant WAITING_FOR_CONFIRMATION_ANSWER_INPUT. */
    public static final String WAITING_FOR_CONFIRMATION_ANSWER_INPUT = "WAITING_FOR_CONFIRMATION_ANSWER_INPUT";

    /** The Constant ORDER_CONFIRMATION_DENIED. */
    public static final String ORDER_CONFIRMATION_DENIED = "ORDER_CONFIRMATION_DENIED";

    /** The Constant PROCUREMENT_REQUEST. */
    public static final String PROCUREMENT_REQUEST = "PC.POMT.ProcurementRequest";

    /** The Constant APPLYING_FOR_ORDER. */
    public static final String APPLYING_FOR_ORDER = "PC.POMT.applyingForOrder";

    /** The Constant WAIT_FOR_ISSUANCE_OF_ORDER. */
    public static final String WAIT_FOR_ISSUANCE_OF_ORDER = "PC.POMT.waitForIssuanceOrder";

    /** The Constant PENDING_ORDER_PENDING. */
    public static final String PENDING_ORDER_PENDING = "PC.POMT.pendingOrdersPending";

    /** The Constant PROVISIONAL_ORDER_PENDING. */
    public static final String PROVISIONAL_ORDER_PENDING = "PC.POMT.pendingOrdersProvisional";

    /** The Constant WAIT_FOR_DELIVERY. */
    public static final String WAIT_FOR_DELIVERY = "PC.POMT.waitForDelivery";

    /** The Constant APPLICATION_UNDER_APPLICATION. */
    public static final String APPLYING = "PC.POMT.ApplicationUnderApplication";

    /** The Constant REMAND. */
    public static final String REMAND = "PC.POMT.remand";

    /** The Constant SCM_PR_ORDER_PROCUREMENT_MESSAGE_INFO. */
    public static final String SCM_PR_ORDER_PROCUREMENT_MESSAGE_INFO = "PC.POMT.procurementRequestMessage";

    /** The Constant SCM_PR_ORDER_APPLYING_MESSAGE_INFO. */
    public static final String SCM_PR_ORDER_APPLYING_MESSAGE_INFO = "PC.POMT.applyMultipleMessage";

    /** The Constant SCM_PR_ORDER_WAITISSUANCE_MESSAGE_INFO. */
    public static final String SCM_PR_ORDER_WAITISSUANCE_MESSAGE_INFO = "PC.POMT.waitForMessage";

    /** The Constant SCM_PR_ORDER_WAITISSUANCE_MESSAGE_INFO. */
    public static final String SCM_PR_ORDER_PROVISIONAL_MESSAGE_INFO = "PC.POMT.pendingProvisionalMessage";

    /** The Constant SCM_PR_ORDER_PENDING_MESSAGE_INFO. */
    public static final String SCM_PR_ORDER_PENDING_MESSAGE_INFO = "PC.POMT.pendingOrder";

    /** The Constant SCM_PR_ORDER_WAITING_MESSAGE_INFO. */
    public static final String SCM_PR_ORDER_WAITING_MESSAGE_INFO = "PC.POMT.waitingMessageInfo";

    /** The Constant SCM_PR_ORDER_WAITING_HEADER_INFO. */
    public static final String SCM_PR_ORDER_WAITING_HEADER_INFO = "PC.POMT.waitingAnswerRegistration";

    /** The Constant SCM_PR_ORDER_PROCUREMENT_SINGLEMESSAGE_INFO. */
    public static final String SCM_PR_ORDER_PROCUREMENT_SINGLEMESSAGE_INFO = "PC.POMT.procurementsingleheader";

    /** The Constant SCM_PR_ORDER_APPLYING_SINGLEMESSAGE_INFO. */
    public static final String SCM_PR_ORDER_APPLYING_SINGLEMESSAGE_INFO = "PC.POMT.applyingSinglemessage";

    /** The Constant SCM_PR_ORDER_WAITISSUANCE_SINGLEMESSAGE_INFO. */
    public static final String SCM_PR_ORDER_WAITISSUANCE_SINGLEMESSAGE_INFO = "PC.POMT.waitsinglemessage";

    /** The Constant SCM_PR_ORDER_PENDING_LISTMESSAGE_INFO. */
    public static final String SCM_PR_ORDER_PENDING_LISTMESSAGE_INFO = "PC.POMT.pendingListMessage";

    /** The Constant SCM_PR_ORDER_WAITINGORDER_SINGLEMESSAGE_INFO. */
    public static final String SCM_PR_ORDER_WAITINGORDER_SINGLEMESSAGE_INFO = "PC.POMT.waitingSingleMessage";

    /** The Constant PURCHASE_ORDER. */
    public static final String PURCHASE_ORDER = "PC.POMT.PurchaseOrder";

    /** The Constant TITLE. */
    public static final String TITLE = "PC.POMT.Title";

    /** The Constant PC_POMT_ALL. */
    public static final String PC_POMT_ALL = "PC.POMT.all";

    /** The Constant DASHBOARD. */
    public static final String DASHBOARD = "dashboard";

    /** The Constant PROCUREMENT. */
    public static final String PROCUREMENT = "procurement";

    /** The Constant APPLY. */
    public static final String APPLY = "apply";

    /** The Constant WAITISSUANCE. */
    public static final String WAITISSUANCE = "waitIssuance";

    /** The Constant PENDING. */
    public static final String PENDING = "pending";

    /** The Constant WAITING. */
    public static final String WAITING = "waiting";

    /** The Constant FINDORDER. */
    public static final String FINDORDER = "findOrder";

    /** The Constant BARCODE. */
    public static final String BARCODE = "barCode";

    /** The Constant LOG_START. */
    public static final int LOG_START = 1;

    /** The Constant LOG_END. */
    public static final int LOG_END = 0;

    /** The Constant NUMERIC_ONE. */
    public static final int NUMERIC_ONE = 1;

    /** The Constant NUMERIC_ZERO. */
    public static final int NUMERIC_ZERO = 0;

    /** The Constant PRE_ORDER_ON_QUOTATION_STATUS_TEXT_ID. */
    public static final String PRE_ORDER_ON_QUOTATION_STATUS_TEXT_ID = "PRE_ORDER_ON_QUOTATION";

    /** The Constant PRE_ORDER_ON_QUOTATION_STATUS_TEXT_ID. */
    public static final String PRE_ORDER_ON_WAITING_FOR_ACCEPTANCE_STATUS_TEXT_ID = "PRE_ORDER_ON_WAITING_FOR_ACCEPTANCE";

    /** The Constant MODIFICATION_ON_TEMPORARY_SAVING_STATUS_TEXT_ID. */
    public static final String MODIFICATION_ON_TEMPORARY_SAVING_STATUS_TEXT_ID = "MODIFICATION_ON_TEMPORARY_SAVING";

    /** The Constant MODIFICATION_REMANDED_STATUS_TEXT_ID. */
    public static final String MODIFICATION_REMANDED_STATUS_TEXT_ID = "MODIFICATION_REMANDED";

    /** The Constant CANCELLATION_REMANDED_STATUS. */
    public static final String CANCELLATION_REMANDED_STATUS_TEXT = "CANCELLATION_REMANDED";

    /** The Constant WAITING_FOR_ORDER_SHEET_PRINTING_STATUS_TEXT_ID. */
    public static final String WAITING_FOR_ORDER_SHEET_PRINTING_STATUS_TEXT_ID = "WAITING_FOR_ORDER_SHEET_PRINTING";

    /** The Constant WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING_STATUS_TEXT_ID. */
    public static final String WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING_STATUS_TEXT_ID = "WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING";

    /** The Constant WAITING_FOR_CONFIRMATION_STATUS_TEXT_ID. */
    public static final String WAITING_FOR_CONFIRMATION_STATUS_TEXT_ID = "WAITING_FOR_CONFIRMATION";

    /** The Constant WAITING_FOR_ATP_ANSWER_STATUS_TEXT_ID. */
    public static final String WAITING_FOR_ATP_ANSWER_STATUS_TEXT_ID = "WAITING_FOR_ATP_ANSWER";

    /** The Constant ORDERING_REMANDED_TEXT_ID. */
    public static final String ORDERING_REMANDED_STATUS_TEXT_ID = "ORDERING_REMANDED";

    /** The Constant ORDERING_ON_REQUEST_TEXT_ID. */
    public static final String ORDERING_ON_REQUEST_STATUS_TEXT_ID = "ORDERING_ON_REQUEST";

    /** The Constant ORDERING_ON_TEMPORARY_SAVING_TEXT_ID. */
    public static final String ORDERING_ON_TEMPORARY_SAVING_STATUS_TEXT_ID = "ORDERING_ON_TEMPORARY_SAVING";

    /** The Constant WAITING_FOR_RECEIVING_STATUS_TEXT_ID. */
    public static final String WAITING_FOR_RECEIVING_STATUS_TEXT_ID = "WAITING_FOR_RECEIVING";

    /** The Constant WAITING_FOR_RECEIVING_STATUS_TEXT_ID. */
    public static final String INNER_MODIFICATION_STATUS_TEXT_ID = "INNER_MODIFICATION";

    /** The Constant WAITING_FOR_RECEIVING_HEADER_ITEM_TEXT_ID. */
    public static final String INNER_MODIFICATION_HEADER_ITEM_TEXT_ID = "PROC.POMT.innerModificationHeaderMessage";

    /** The Constant WAITING_FOR_RECEIVING_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_RECEIVING_HEADER_ITEM_TEXT_ID = "PC.POMT.waitingForReceivingMessage";

    /** The Constant WAITING_FOR_ORDER_MATCHING_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_ORDER_MATCHING_HEADER_ITEM_TEXT_ID = "PC.POMT.waitingForOrderMatchingMessage";

    /** The Constant WAITING_FOR_RECEIVING_HEADER_ITEM_TEXT_ID. */
    public static final String ORDER_MATCHING_COMPLETED_HEADER_ITEM_TEXT_ID = "PC.POMT.orderMatchingCompleteMessage";

    /** The Constant WAITING_FOR_RECEIVING_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_PROGRESS_BASED_INSPECTION_HEADER_ITEM_TEXT_ID = "PC.POMT.waitingForProgressBasedInspectionMessage";

    /** The Constant WAITING_FOR_RECEIVING_HEADER_ITEM_TEXT_ID. */
    public static final String PROGRESS_BASED_INSPECTING_HEADER_ITEM_TEXT_ID = "PC.POMT.progressBasedInspectingMessage";

    /** The Constant MAKE_YOURSELF_ITEM_TEXT_ID. */
    public static final String MAKE_YOURSELF_ITEM_TEXT_ID = "PC.POMT.makeyourself";

    /** The Constant CHANGE_RESPONSIBILITY_ITEM_TEXT_ID. */
    public static final String CHANGE_RESPONSIBILITY_ITEM_TEXT_ID = "PC.POMT.changeResponsibleToMe";

    /** The Constant CHANGE_CHARGE_ITEM_TEXT_ID. */
    public static final String CHANGE_CHARGE_ITEM_TEXT_ID = "PC.POMT.changeCharge";

    /** The Constant COPY_ITEM_TEXT_ID. */
    public static final String COPY_ITEM_TEXT_ID = "PC.POMT.copy";

    /** The Constant ORDER_ITEM_TEXT_ID. */
    public static final String ORDER_ITEM_TEXT_ID = "PC.POMT.order";

    /** The Constant TOSELECT_ITEM_TEXT_ID. */
    public static final String TOSELECT_ITEM_TEXT_ID = "PC.POMT.toSelect";

    /** The Constant REQUEST_ADDITIONAL_QUOTATION_ITEM_TEXT_ID. */
    public static final String REQUEST_ADDITIONAL_QUOTATION_ITEM_TEXT_ID = "PC.POMT.requestAdditionalQuotation";

    /** The Constant RETRIEVE_TO_REQUESTER_ITEM_TEXT_ID. */
    public static final String RETRIEVE_TO_REQUESTER_ITEM_TEXT_ID = "PC.POMT.retrieveToRequester";

    /** The Constant RESUME_APPLICATION_ITEM_TEXT_ID. */
    public static final String RESUME_APPLICATION_ITEM_TEXT_ID = "PC.POMT.resumeApplication";

    /** The Constant DISCARD_APPLICATION_ITEM_TEXT_ID. */
    public static final String DISCARD_APPLICATION_ITEM_TEXT_ID = "PC.POMT.discardApplication";

    /** The Constant CANCEL_APPLICATION_ITEM_TEXT_ID. */
    public static final String CANCEL_APPLICATION_ITEM_TEXT_ID = "PC.POMT.cancelApplication";

    /** The Constant REGAIN_APPLICATION_ITEM_TEXT_ID. */
    public static final String REGAIN_APPLICATION_ITEM_TEXT_ID = "PC.POMT.regainApplication";

    /** The Constant TO_REAPPLY_ITEM_TEXT_ID. */
    public static final String TO_REAPPLY_ITEM_TEXT_ID = "PC.POMT.toReapply";

    /** The Constant REAPPLY_CHANGE_ORDER. */
    public static final String REAPPLY_CHANGE_ORDER = "PC.POMT.reapplyChangeOrder";

    /** The Constant REAPPLY_CANCEL_ORDER. */
    public static final String REAPPLY_CANCEL_ORDER = "PC.POMT.reapplyCancelOrder";

    /** The Constant CANCEL_PURCHASE_ORDER_ITEM_TEXT_ID. */
    public static final String CANCEL_PURCHASE_ORDER_ITEM_TEXT_ID = "PC.POMT.cancelPurchaseOrder";

    /** The Constant PRINT_SAVE_PURCHASE_ORDER_ITEM_TEXT_ID. */
    public static final String PRINT_SAVE_PURCHASE_ORDER_ITEM_TEXT_ID = "PC.POMT.printSavePurchaseOrder";

    /** The Constant PROC_POMT_DELIVERY_NOTE_HEADER. */
    public static final String PROC_POMT_DELIVERY_NOTE_HEADER = "PROC.POMT.deliveryNoteHeader";

    /** The Constant deliveryNote for report setting */
    public static final String DELIVERY_NOTE_REPORT = "deliveryNote";

    /** The Constant PROC_POMT_DELIVERY_NOTE_HEADER. */
    public static final String CANCEL_ORDER_CONFIRMATION = "PROC.POMT.cancelOrderConfirmation";

    /** The Constant orderConfirmation for report setting */
    public static final String ORDER_CONFIRMATION_REPORT = "orderConfirmation";

    /** The Constant ASK_FOR_CHANGE_ITEM_TEXT_ID. */
    public static final String ASK_FOR_CHANGE_ITEM_TEXT_ID = "PC.POMT.askForChange";

    /** The Constant CERTAIN_DETAILS_ABORTED_ITEM_TEXT_ID. */
    public static final String CERTAIN_DETAILS_ABORTED_ITEM_TEXT_ID = "PC.POMT.certainDetailsAborted";

    /** The Constant CHANGE_PURCHASE_ORDER_ITEM_TEXT_ID. */
    public static final String START_PURCHASE_ORDER_ITEM_TEXT_ID = "PC.POMT.startPurchaseOrder";

    /** The Constant CHANGE_PURCHASE_ORDER_ITEM_TEXT_ID. */
    public static final String TAKE_QUOTATION_ITEM_TEXT_ID = "PC.POMT.takeQuotation";

    /** The Constant CHANGE_PURCHASE_ORDER_ITEM_TEXT_ID. */
    public static final String CHANGE_PURCHASE_ORDER_ITEM_TEXT_ID = "PC.POMT.changePurchaseOrder";

    /** The Constant CHANGE_PURCHASE_ORDER_ITEM_TEXT_ID. */
    public static final String CHANGE_PURCHASE_ORDER_DELIVERY_ITEM_TEXT_ID = "PC.POMT.changePurchaseOrderDelivery";

    /** The Constant CONFIRM_DELIVERY_DATE_ITEM_TEXT_ID. */
    public static final String CONFIRM_DELIVERY_DATE_ITEM_TEXT_ID = "PC.POMT.confirmDeliveryDate";

    /** The Constant FIX_DELIVERY_DATE_ITEM_TEXT_ID. */
    public static final String FIX_DELIVERY_DATE_ITEM_TEXT_ID = "PC.POMT.fixDeliveryDate";

    /** The Constant PRE_ORDER_ON_QUOTATION_HEADER_ITEM_TEXT_ID. */
    public static final String PRE_ORDER_ON_QUOTATION_HEADER_ITEM_TEXT_ID = "PC.POMT.requestForProcurement";

    /** The Constant PRE_ORDER_ON_QUOTATION_CONTENT_ITEM_TEXT_ID. */
    public static final String PRE_ORDER_ON_QUOTATION_CONTENT_ITEM_TEXT_ID = "PC.POMT.selectOrderPlacement";

    /** The Constant ORDERING_ON_REQUEST_HEADER_ITEM_TEXT_ID. */
    public static final String ORDERING_ON_REQUEST_HEADER_ITEM_TEXT_ID = "PC.POMT.applicationInProgress";

    /** The Constant ORDERING_ON_TEMPORARY_SAVING_HEADER_ITEM_TEXT_ID. */
    public static final String ORDERING_ON_TEMPORARY_SAVING_HEADER_ITEM_TEXT_ID = "PC.POMT.temporarilyStored";

    /** The Constant ORDERING_ON_TEMPORARY_SAVING_HEADER_ITEM_TEXT_ID. */
    public static final String ORDERING_ON_TEMPORARY_SAVING_HEADER_CONDITION_ITEM_TEXT_ID = "PC.POMT.storedTemporarily";

    /** The Constant ORDERING_REMANDED_HEADER_ITEM_TEXT_ID. */
    public static final String ORDERING_REMANDED_HEADER_ITEM_TEXT_ID = "PC.POMT.beingReturned";

    /** The Constant ORDERING_REMANDED_CONTENT_ITEM_TEXT_ID. */
    public static final String ORDERING_REMANDED_CONTENT_ITEM_TEXT_ID = "PC.POMT.editTheContents";

    /** The Constant ORDERING_REMANDED_HEADER_ITEM_TEXT_ID. */
    public static final String MODIFICATION_REMANDED_HEADER_ITEM_TEXT_ID = "PC.POMT.modificationRemandedInfo";

    /** The Constant ORDERING_REMANDED_CONTENT_ITEM_TEXT_ID. */
    public static final String MODIFICATION_REMANDED_CONTENT_ITEM_TEXT_ID = "PC.POMT.modificationResubmit";

    /** The Constant ORDERING_REMANDED_HEADER_ITEM_TEXT_ID. */
    public static final String CANCELLATION_REMANDED_HEADER_ITEM_TEXT_ID = "PC.POMT.cancellationRemandedInfo";

    /** The Constant ORDERING_REMANDED_CONTENT_ITEM_TEXT_ID. */
    public static final String CANCELLATION_REMANDED_CONTENT_ITEM_TEXT_ID = "PC.POMT.cancellationResubmit";

    /** The Constant WAITING_FOR_ORDER_ISSUE_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_ORDER_ISSUE_HEADER_ITEM_TEXT_ID = "PC.POMT.waitingForOrderIssue";

    /** The Constant WAITING_FOR_ORDER_MODIFICATION_ISSUE_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_ORDER_MODIFICATION_ISSUE_HEADER_ITEM_TEXT_ID = "PC.POMT.waitingForModificationOrderIssue";

    /** The Constant WAITING_FOR_CONFIRMATION_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_CONFIRMATION_HEADER_ITEM_TEXT_ID = "PC.POMT.awaitingMyOrder";

    /** The Constant WAITING_FOR_ATP_ANSWER_HEADER_ITEM_TEXT_ID. */
    public static final String WAITING_FOR_ATP_ANSWER_HEADER_ITEM_TEXT_ID = "PC.POMT.deliveryIsWaiting";

    /** The Constant PC_POMT_WAITING_FOR_RECEIVING. */
    public static final String PC_POMT_WAITING_FOR_RECEIVING = "PC.POMT.waitingForReceiving";

    /** The Constant SPACE_RECORDS_TEXT_ID. */
    public static final String SPACE_RECORDS_TEXT_ID = "PC.POMT.records";

    /** The Constant SPACE_RECORD_TEXT_ID. */
    public static final String SPACE_RECORD_TEXT_ID = "PC.POMT.record";

    /** The Constant ORDER_FORM_TEXT_ID. */
    public static final String ORDER_FORM_TEXT_ID = "PC.POMT.detailOrderForm";

    /** The Constant PURCHASE_ORDER_PRINT_HEADER_TEXT_ID. */
    public static final String PURCHASE_ORDER_PRINT_HEADER_TEXT_ID = "PC.POMT.purchaseOrder";

    /** The Constant SEPERATOR_CONSTANT. */
    public static final String SEPERATOR_CONSTANT = "PC.POMT.slash";

    /** The Constant ADVANCED_INPUT_AREA_TEXT_ID. */
    public static final String ADVANCED_INPUT_AREA_TEXT_ID = "advancedInputArea";

    /** The Constant HOVER_ADVANCED_INPUT_AREA_TEXT_ID. */
    public static final String HOVER_ADVANCED_INPUT_AREA_TEXT_ID = "hoverAdvancedInputArea";

    /** The Constant ORDER_DETAIL_VIEW_KEY. */
    public static final String ORDER_DETAIL_VIEW_KEY = "orderDetailViewKey";

    /** The Constant ORDER_DETAIL_VIEW_KEY. */
    public static final String REQUEST_DETAIL_VIEW_KEY = "requestDetailViewKey";

    /** The Constant PURCHASE_ORDER_MANAGEMENT_DETAIL. */
    public static final String PURCHASE_ORDER_MANAGEMENT_DETAIL = "PC.POMT.purchaseOrderDetail";

    /** The Constant ORDER_DETAIL_FORM. */
    public static final String ORDER_DETAIL_FORM = "PC.POMT.orderDetailForm";

    /** The Constant PURCHASE_ORDER_APPLICATION_SERVICE_DEF_ID. */
    public static final String PURCHASE_ORDER_APPLICATION_SERVICE_DEF_ID = "ScmProcurementPurchaseOrderApplication";

    /** The Constant PURCHASE_ORDER_EXTERNAL_APPLICATION_SERVICE_DEF_ID. */
    public static final String PURCHASE_ORDER_EXTERNAL_APPLICATION_SERVICE_DEF_ID = "ScmProcurementPurchaseOrderExternalApplication";

    /** The Constant PURCHASE_ORDER_APPLICATION_FIRST_PAGE_TOKEN. */
    public static final String PURCHASE_ORDER_APPLICATION_FIRST_PAGE_TOKEN = "orderApplicationFirstPageToken";

    /** The Constant PURCHASE_ORDER_APPLICATION_INPUT_PATH. */
    public static final String PURCHASE_ORDER_APPLICATION_INPUT_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderapplication/fragment/purchase-order-application-input";

    /** The Constant PURCHASE_ORDER_APPLICATION_CONFIRM_PATH. */
    public static final String PURCHASE_ORDER_APPLICATION_CONFIRM_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderapplication/fragment/purchase-order-application-confirm";

    /** The Constant PURCHASE_ORDER_APPLICATION_FINISH_PATH. */
    public static final String PURCHASE_ORDER_APPLICATION_FINISH_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderapplication/fragment/purchase-order-application-finish";

    /** The Constant PURCHASE_ORDER_APPLICATION_INPUT_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_INPUT_KEY = "purchaseOrderApplicationInput";

    /** The Constant PURCHASE_ORDER_APPLICATION_CONFIRM_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_CONFIRM_KEY = "purchaseOrderApplicationConfirm";

    /** The Constant PURCHASE_ORDER_APPLICATION_FINISH_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_FINISH_KEY = "purchaseOrderApplicationFinish";

    /** The Constant PURCHASE_ORDER_APPLICATION_FRAMESET_PATH. */
    public static final String PURCHASE_ORDER_APPLICATION_FRAMESET_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderapplication/purchase-order-application-framset";

    /** The Constant SALES_CONTRACT_REGISTER_FRAMESET_INPUT_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_CONFIG_INPUT_KEY = "inputConfigKey";

    /** The Constant SALES_CONTRACT_REGISTER_FRAMESET_CONFIRM_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_CONFIG_CONFIRM_KEY = "confirmConfigKey";

    /** The Constant SALES_CONTRACT_REGISTER_FRAMESET_FINISH_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_CONFIG_FINISH_KEY = "finishConfigKey";

    /** The Constant PURCHASE_ORDER_APPLICATION_INPUT_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_FRAMSET_INPUT_KEY = "purchaseOrderApplicationFramsetInput";

    /** The Constant PURCHASE_ORDER_APPLICATION_CONFIRM_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_FRAMSET_CONFIRM_KEY = "purchaseOrderApplicationFramsetConfirm";

    /** The Constant PURCHASE_ORDER_APPLICATION_FINISH_KEY. */
    public static final String PURCHASE_ORDER_APPLICATION_FRAMSET_FINISH_KEY = "purchaseOrderApplicationFramsetFinish";

    /** The Constant PURCHASE_ORDER_APPLICATION_FINISH_KEY. */
    public static final String INPUT_KEY = "input";

    /** The Constant INPUT_VIEW_ID_KEY. */
    public static final String INPUT_VIEW_ID_KEY = "inputViewIdKey";

    /** The Constant CONFIRM_VIEW_ID_KEY. */
    public static final String CONFIRM_VIEW_ID_KEY = "confirmViewIdKey";

    /** The Constant FINISH_VIEW_ID_KEY. */
    public static final String FINISH_VIEW_ID_KEY = "finishViewIdKey";

    /** The Constant ORDER_DETAIL_GRID. */
    public static final String ORDER_DETAIL_GRID = "orderApplicationContents.orderDetailEntityList";

    /** The Constant ITEM_NAME. */
    public static final String ITEM_NAME = "itemNameValue";

    /** The Constant ITEM_CLASSIFICATION_NAME. */
    public static final String ITEM_CLASSIFICATION_NAME = "itemClassificationNameValue";

    /** The Constant PROVISIONAL_ORDER_SEGMENT_VALUE. */
    public static final String PROVISIONAL_ORDER_SEGMENT_VALUE = "provisionalOrderSegementValue";

    /** The Constant ITEM_NAME_SUPPLEMENT_VALUE. */
    public static final String SPECIFICATION_VALUE = "specificationValue";

    /** The Constant SPECIFICATION_SUPPLEMENT_VALUE. */
    public static final String SPECIFICATION_SUPPLEMENT_VALUE = "specificationSupplementValue";

    /** The Constant CONSUMPTION_TAX_RATE_VALUE. */
    public static final String CONSUMPTION_TAX_RATE_VALUE = "consumptionTaxRateValue";

    /** The Constant ITEM_NAME_SUPPLEMENT_VALUE. */
    public static final String ITEM_NAME_SUPPLEMENT_VALUE = "itemNameSupplementValue";

    /** The Constant QUANTITY. */
    public static final String QUANTITY = "quantity";

    /** The Constant UNIT_NAME. */
    public static final String UNIT_NAME = "unit_name";

    /** The Constant UNIT_PRICE. */
    public static final String UNIT_PRICE = "unitPrice";

    /** The Constant TAX_EXCLUDED_AMOUNT. */
    public static final String TAX_EXCLUDED_AMOUNT = "taxExcludedAmount";

    /** The Constant ITEM_NUMBER. */
    public static final String ITEM_NUMBER = "orderDetailNo";

    /** The Constant GRID_VALIDATOR. */
    public static final String GRID_VALIDATOR = "orderApplicationContents.orderDetailEntityList";

    /** The Constant ITEM_NAME_VALIDATOR. */
    public static final String ITEM_NAME_VALIDATOR = "orderApplicationContents.orderDetailEntityList.itemNameValue";

    /** The Constant ITEM_CLASSIFICATION_NAME_VALIDATOR. */
    public static final String ITEM_CLASSIFICATION_NAME_VALIDATOR = "orderApplicationContents.orderDetailEntityList.itemClassificationNameValue";

    /** The Constant QUANTITY_VALIDATOR. */
    public static final String QUANTITY_VALIDATOR = "orderApplicationContents.orderDetailEntityList.quantity";

    /** The Constant UNIT_VALIDATOR. */
    public static final String UNIT_VALIDATOR = "orderApplicationContents.orderDetailEntityList.unitNameValue";

    /** The Constant UNIT_PRICE_VALIDATOR. */
    public static final String UNIT_PRICE_VALIDATOR = "orderApplicationContents.orderDetailEntityList.unitPrice";

    /** The Constant PAYMENT_TERMS. */
    public static final String PAYMENT_TERMS = "orderApplicationContents.orderDetailEntityList.paymentTermsNameValue";

    /** The Constant SUBCONTRACT_SUBJECT. */
    public static final String SUBCONTRACT_SUBJECT = "orderApplicationContents.orderDetailEntityList.subcontractActApplicationDiv";

    /** The Constant ORDER_NUMBER. */
    public static final String ORDER_NUMBER = "orderApplicationContents.orderDetailEntityList.orderNumber";

    /** The Constant ORDER_REVISION_NUMBER. */
    public static final String ORDER_REVISION_NUMBER = "orderApplicationContents.orderDetailEntityList.orderRevisionNumber";

    /** The Constant PARTIAL_UPDATE_CONFIRM. */
    public static final String PARTIAL_UPDATE_CONFIRM = "#comfirm appId = {}, model -> \n {}";

    /** The Constant PARTIAL_UPDATE_FINISH. */
    public static final String PARTIAL_UPDATE_FINISH = "#finish appId = {}, model -> \n {}";

    /** The Constant SAVE. */
    public static final String SAVE = "#save model -> \n {}";

    /** The Constant RESTART. */
    public static final String RESTART = "#restart appId = {}";

    /** The Constant COPY. */
    public static final String COPY = "#copy appId = {}";

    /** The Constant INPUT. */
    public static final String INPUT = "#input appId = {}, appStatus = {}, otherAppId = {}";

    /** The Constant APP_STATUS. */
    public static final String APP_STATUS = "appStatus";

    /** The Constant NOT_ATTACHED. */
    public static final String NOT_ATTACHED = "PC.POMT.fileNotAttach";

    /** The Constant NAME_SIMA_GRID_COLUMN. */
    public static final String NAME_SIMA_GRID_COLUMN = "itemNameValue";

    /** The Constant SCM_COM_PROCUREMENT_MATERIAL_MASTER. */
    public static final String SCM_COM_PROCUREMENT_MATERIAL_MASTER = "SCM_COM_PROCUREMENT_MATERIAL_MASTER";

    /** The Constant SCM_COM_PROCUREMENT_ITEM_SEARCH */
    public static final String SCM_COM_PROCUREMENT_ITEM_SEARCH = "SCM_PROCUREMENT_REQUEST_ITEM_SEARCH";

    /** The Constant DOC. */
    public static final String DOC = "code";

    /** The Constant NAME. */
    public static final String NAME = "item_name";

    /** The Constant NAME_SUPPLEMENT. */
    public static final String NAME_SUPPLEMENT = "name_supplement";

    /** The Constant SPECIFICATION. */
    public static final String SPECIFICATION = "specifications";

    /** The Constant SPECIFICATION_SUPPLEMENT. */
    public static final String SPECIFICATION_SUPPLEMENT = "specification_supplement";

    /** The Constant UNIT. */
    public static final String UNIT = "unit_name";

    /** The Constant UNIT_PRICE_ID. */
    public static final String UNIT_PRICE_ID = "unit_price";

    /** The Constant TAX_RATE. */
    public static final String TAX_RATE = "tax_rate";

    /** The Constant CONSTRUCTION. */
    public static final String CONSTRUCTION = "construction";

    /** The Constant QUOTATION. */
    public static final String QUOTATION = "quotation";

    /** The Constant PARAM. */
    public static final String PARAM = "param";

    /** The Constant FIELD_REQUIRED. */
    public static final String FIELD_REQUIRED = "PC.POMT.required";

    /** The Constant DEPRECATION. */
    public static final String DEPRECATION = "deprecation";

    /** The Constant PROCUREMENT_REQUEST_TYPE. */
    public static final String PROCUREMENT_REQUEST_TYPE = "PROCUREMENT_REQUEST";
    /** The Constant ORDER_PLAN_ID. */
    public static final String ORDER_PLAN_ID = "orderPlanId";

    /** The Constant REQUEST. */
    public static final String REQUEST = "request";

    /** The Constant DELIVERY. */
    public static final String DELIVERY = "delivery";

    /** The Constant CASE. */
    public static final String CASE = "case";

    /** The Constant ORDER. */
    public static final String ORDER = "order";

    /** The Constant APPLICATION. */
    public static final String APPLICATION = "application";

    /** The Constant SENDING. */
    public static final String SENDING = "sending";

    /** The Constant ASCENDING. */
    public static final String ASCENDING = "ascending";

    /** The Constant DATAVALUE. */
    public static final String DATAVALUE = "dataValue";

    /** The Constant MODEVALUE. */
    public static final String MODEVALUE = "modeValue";

    /** The Constant EMPTY. */
    public static final String ATP_CONDITION_PLEASE_INPUT = "PC.POMT.ATPCONDITION.notInput";

    /** The Constant ORDERED. */
    public static final String ATP_CONDITION_AS_EXPECTED = "PC.POMT.ATPCONDITION.asExpected";

    /** The Constant RED. */
    public static final String SCM_PR_ORDER_RED = "red";

    /** The Constant GREEN. */
    public static final String SCM_PR_ORDER_GREEN = "green";

    /** The Constant QUANTITY_AT_TIME_OF_COMPLETION. */
    public static final String ATP_CONDITION_ANSWERED_QUANTITY_SURPLUS = "PC.POMT.ATPCONDITION.quantitySurplus";

    /** The Constant QUANTITY_AT_TIME_OF_COMPLETION_UNIT_LESS. */
    public static final String ATP_CONDITION_ANSWERED_QUANTITY_SHORTAGE = "PC.POMT.ATPCONDITION.quantityShortage";

    /** The Constant BUSINESS_DAYS_PREPAID. */
    public static final String ATP_CONDITION_ANSWERED_PREDELIVERED = "PC.POMT.ATPCONDITION.preDelivered";

    /** The Constant BUSINESS_DAYS_DELAYED . */
    public static final String ATP_CONDITION_ANSWERED_DELAY_DELIVERY = "PC.POMT.ATPCONDITION.deliveryDateDelay";

    /** The Constant UNIT_MANY. */
    public static final String ATP_CONDITION_SURPLUS_AND_PREDELIVERED = "PC.POMT.ATPCONDITION.surplusAndPredelivered";

    /** The Constant UNIT_LESS. */
    public static final String ATP_CONDITION_SHORTAGE_AND_PREDELIVERED = "PC.POMT.ATPCONDITION.shortageAndPredelivered";

    /** The Constant SCM_PR_ORDER_NEW_UNIT_MANY. */
    public static final String ATP_CONDITION_SURPLUS_AND_DELAY = "PC.POMT.ATPCONDITION.surplusAndDelay";

    /** The Constant NEW_UNIT_LESS. */
    public static final String ATP_CONDITION_SHORTAGE_AND_DELAY = "PC.POMT.ATPCONDITION.shortageAndDelay";

    /** The Constant SCM_PR_ORDER_ID. */
    public static final String SCM_PR_ORDER_ID = "orderId";

    /** The Constant PRINT_ORDER_INBOX_LIST. */
    public static final String PRINT_ORDER_INBOX_LIST = "print-order-inbox-list";

    /** The Constant SCM_PROCUREMENT_PURCHASE_ORDER_PORTAL. */
    public static final String SCM_PROCUREMENT_PURCHASE_ORDER_PORTAL = "ScmProcurementPurchaseOrderPortal";

    /** The Constant PRINT_ORDER_INBOX_LIST_NAME. */
    public static final String PRINT_ORDER_INBOX_LIST_NAME = "printOrderInboxList";

    /** The Constant ITEM_NAME_REPORT. */
    public static final String ITEM_NAME_REPORT = "itemName";

    /** The Constant SERIAL_NO. */
    public static final String SERIAL_NO = "SeialNo";

    /** The Constant ITEM_CODE. */
    public static final String ITEM_CODE = "itemCode";

    /** The Constant ITEM_ID */
    public static final String ITEM_ID = "itemId";

    /** The Constant ITEM_ID for docsearch */
    public static final String ITEM_ID_FOR_DOCSEARCH = "item_id";

    /** The Constant SUM_MONEY. */
    public static final String SUM_MONEY = "sumMoney";

    /** The Constant SUPPLEMENT. */
    public static final String SUPPLEMENT = "supplement";

    /** The Constant DELIVERY_PLACE. */
    public static final String DELIVERY_PLACE = "deliveryPlace";

    /** The Constant ADDRESS. */
    public static final String ADDRESS = "address";

    /** The Constant POSTAL_CODE. */
    public static final String POSTAL_CODE = "postalCode";

    /** The Constant TELEPHONE_NUMBER. */
    public static final String TELEPHONE_NUMBER = "phoneNumber";

    /** The Constant GRID_DATAS. */
    public static final String GRID_DATAS = "GridDatas";

    /** The Constant MAIN_DATA_SOURCE. */
    public static final String MAIN_DATA_SOURCE = "main-data-source";

    /** The Constant SUB_DATA_SOURCE_MAP. */
    public static final String SUB_DATA_SOURCE_MAP = "sub-data-source-map";

    /** The Constant REPORT_SETTING_ENTITY. */
    public static final String REPORT_SETTING_ENTITY = "report-setting-entity";

    /** The Constant NUMBER. */
    public static final String NUMBER = "number";

    /** The Constant PC_POMT_PRINT. */
    public static final String PC_POMT_PRINT = "PC.POMT.print";

    /** The Constant PC_POMT_DOWNLOAD. */
    public static final String PC_POMT_DOWNLOAD = "PC.POMT.download";

    /** The Constant PC_POMT_PURCHASE_ORDER_HEADER. */
    public static final String PC_POMT_PURCHASE_ORDER_HEADER = "PC.POMT.purchaseOrderHeader";

    /** The Constant FINAL. */
    public static final String FINAL = "final";

    /** The Constant PC_POMT_PURCHASE_ORDER_COPY. */
    public static final String PC_POMT_PURCHASE_ORDER_COPY = "PC.POMT.purchaseOrderCopy";

    /** The constant orderCopy for report setting */
    public static final String ORDER_COPY_REPORT = "orderCopy";

    /** The Constant PC_POMT_ORDER_CONFIRMATION_HEADER. */
    public static final String PC_POMT_ORDER_CONFIRMATION_HEADER = "PC.POMT.orderConfirmationHeader";

    /** The Constant PURCHASE_ORDER_REPORT. */
    public static final String PURCHASE_ORDER_REPORT = "purchaseOrder";

    /** The Constant CURRENT_DATE_REPORT. */
    public static final String CURRENT_DATE_REPORT = "currentDate";

    /** The Constant SUPPLIER_REPORT. */
    public static final String SUPPLIER_REPORT = "supplier";

    /** The Constant DEAL_TYPE_REPORT. */
    public static final String DEAL_TYPE_REPORT = "dealType";

    /** The Constant ORDER_DATE_REPORT. */
    public static final String ORDER_DATE_REPORT = "orderDate";

    /** The Constant SUM_TAX_INCLUDED_MONEY_REPORT. */
    public static final String SUM_TAX_INCLUDED_MONEY_REPORT = "sumTaxIncludedMoney";

    /** The Constant SUM_MONEY_TAX_ECLUDED_REPORT. */
    public static final String SUM_MONEY_TAX_ECLUDED_REPORT = "sumMoneyTaxEcluded";

    /** The Constant CORP_CODE_NAME_REPORT. */
    public static final String CORP_CODE_NAME_REPORT = "corpCodeName";

    /** The Constant TAX_REPORT. */
    public static final String TAX_REPORT = "tax";

    /** The Constant PC_POMT_COMMA. */
    public static final String PC_POMT_COMMA = "PC.POMT.comma";

    /** The Constant ON_ORDER. */
    public static final String ON_ORDER = "ON_ORDER";

    /** The Constant WAITING_FOR_ATP_ANSWER. */
    public static final String WAITING_FOR_ATP_ANSWER = "WAITING_FOR_ATP_ANSWER";

    /** The Constant TYPE_APPLYING. */
    public static final String TYPE_APPLYING = "APPLYING";

    /** The Constant DELIVERY_LINE_SIMA_GRID. */
    public static final String DELIVERY_LINE_SIMA_GRID = "delivery-line-sima-grid";

    /** The Constant DELIVERY_LINE_SIMA_GRID_NAME. */
    public static final String DELIVERY_LINE_SIMA_GRID_NAME = "deliveryLineSimaGrid";

    /** The Constant PURCHASER_TEXT_INPUT. */
    public static final String PURCHASER_TEXT_INPUT = "purchaser-text-input";

    /** The Constant TRUE_VALUE. */
    public static final Boolean TRUE_VALUE = true;

    /** The Constant TRUE_VALUE. */
    public static final Boolean FALSE_VALUE = false;

    /** The Constant SEE_MORE_BUTTON. */
    public static final String SEE_MORE_BUTTON = "see-more-anchor-label";

    /** The Constant NUMERIC_FIVE. */
    public static final int NUMERIC_FIVE = 5;

    /** The Constant BARCODE_ACCEPT_MESSAGE. */
    public static final String BARCODE_ACCEPT_MESSAGE = "PC.POMT.receivedMessage";

    /** The Constant BARCODE_NOT_ACCEPT_MESSAGE. */
    public static final String BARCODE_NOT_ACCEPT_MESSAGE = "PC.POMT.unreceivedMessage";

    /** The Constant MAKE_ITANORDER_ACCEPTED. */
    public static final String ENTER_DATE_OF_CONTRACT = "Enter_date_of_contract";

    /** The Constant BARCODE_ALREADY_RECEIVED_MESSAGE. */
    public static final String BARCODE_ALREADY_ACCEPTED_MESSAGE = "PC.POMT.acceptedMessage";

    /** The Constant DESCENDING. */
    public static final String DESCENDING = "descending";

    /** The Constant URL_START_SID. */
    public static final String URL_LOAD_PAGE_SID = "/loadPage?sid=";

    /** The Constant URL_START_SID. */
    public static final String START_CORRECT = "/startCorrect?sid=";

    /** The Constant URL_START_SID. */
    public static final String RESTART_CORRECT = "/restartCorrect?sid=";

    /** The Constant CANCEL_URL_START_SID. */
    public static final String START_CANCEL = "/cancelStart?sid=";

    /** The Constant URL_START_SID. */
    public static final String RESTART_CANCEL = "/restartCancel?sid=";

    /** The Constant NUMERIC_THIRTY_SIX. */
    public static final int NUMERIC_THIRTY_SIX = 36;

    /** The Constant RESUME_PARAMETER. */
    public static final String RESUME_PARAMETER = "resume";

    /** The Constant MESSAGE_ID. */
    public static final String MESSAGE_ID = "scm.procurement.purchaseorder.makeorder";

    /** The Constant ATTACH_ESTIMATE. */
    public static final String ATTACH_ESTIMATE = "PC.POMT.pleaseAttachAnEstimate";

    /** The Constant CONTROL_FORM_INBOX_LIST. */
    public static final String CONTROL_FORM_INBOX_LIST = "control-form-inbox-list";

    /** The Constant SENDING_FORM_INBOX_LIST. */
    public static final String SENDING_FORM_INBOX_LIST = "sending-form-inbox-list";

    /** The Constant SENDING_FORM_INBOX_LIST. */
    public static final String MESSAGE_AREA = "message-area";

    /** The Constant ITEM_CLASSIFICATION_VALIDATE_DATA. */
    public static final String ITEM_CLASSIFICATION_VALIDATE_DATA = "PC.POMT.itemClassificationGridData";

    /** The Constant PURCHASE_REQUEST_NUMBER_VALIDATE_DATA. */
    public static final String PURCHASE_ORDER_NUMBER_VALIDATE_DATA = "PC.POMT.purchaseOrderNumberGridData";

    /** The Constant OFFICE_NAME_VALIDATE_DATA. */
    public static final String SUBCONTRACT_VALIDATE_DATA = "PC.POMT.subContractGridData";

    /** The Constant PERIOD_NUMBER_VALIDATE_DATA. */
    public static final String PAYMENT_TERMS_VALIDATE_DATA = "PC.POMT.paymentTermsGridData";

    /** The Constant FINISH_DATA. */
    public static final String FINISH_DATA = "PROC.POMT.finishLabel";

    /** The Constant PC_POMT_REFINE_BY. */
    public static final String PC_POMT_REFINE_BY = "PC.POMT.refineBy";

    /** The Constant PC_POMT_SEE_MORE. */
    public static final String PC_POMT_SEE_MORE = "PC.POMT.seeMore";

    /** The Constant PC_POMT_SHOW_LESS. */
    public static final String PC_POMT_SHOW_LESS = "PC.POMT.showLess";

    /** The Constant COG. */
    public static final String COG = "cog";

    /** The Constant PC_POMT_ORDER_STATUS. */
    public static final String PC_POMT_ORDER_STATUS = "PC.POMT.orderStatus";
    /** The Constant PC_POMT_SERVICE_NAME. */
    public static final String PC_POMT_SERVICE_NAME = "PC.POMT.serviceName";
    /** The Constant PC_POMT_ORDER_DATE. */
    public static final String PC_POMT_ORDER_DATE = "PC.POMT.orderDate";
    /** The Constant PC_POMT_DELIVERY_DATE. */
    public static final String PC_POMT_DELIVERY_DATE = "PC.POMT.deliveryDate";

    /** The Constant PC_POMT_PERSON_IN_CHARGE. */
    public static final String PC_POMT_PERSON_IN_CHARGE = "PC.POMT.personInCharge";

    /** The Constant PC_POMT_TODAY. */
    public static final String PC_POMT_TODAY = "PC.POMT.Today";
    /** The Constant PC_POMT_LESS_THAN_1_MONTH. */
    public static final String PC_POMT_LESS_THAN_1_MONTH = "PC.POMT.lessThan1Month";

    /** The Constant PC_POMT_LESS_THAN_3_MONTH. */
    public static final String PC_POMT_LESS_THAN_3_MONTH = "PC.POMT.lessThan3Month";

    /** The Constant FIND_ORDER_FILTER_INBOX_LIST. */
    public static final String FIND_ORDER_FILTER_INBOX_LIST = "find-order-filter-inbox-list";

    /** The Constant FIND_ORDER_FILTER_DETAIL_INBOX_LIST */
    public static final String FIND_ORDER_FILTER_DETAIL_INBOX_LIST = "find-order-filter-detail-inbox-list";

    /** The Constant DELIVERY_DATE_VALUE. */
    public static final String DELIVERY_DATE_VALUE = "deliveryDate";

    /** The Constant DELIVERY_DATE_VALUE. */
    public static final String FIND_ORDER_INBOX_LIST = "find-order-inbox-list";

    /**
     * The url fragment of the method which opens a order detail page(not as a list).<br>
     * Currently this is used when we call redirect method to detail page from the other page.
     */
    public static final String ORDER_DETAIL_VIEW_URL_FRAGMENT = "/orderDetailSingle";

    /** The Search Fetch Field List. */
    public static final ImmutableList<String> SEARCH_FETCH_FIELD_LIST = ImmutableList.of(
            "order_id", "order_type", "order_title",
            "order_plan_title",
            "sending_method_name", "sending_method_plan_name",
            "order_status", "order_plan_status", "order_status_name", "order_plan_status_name",
            "supplier_name", "supplier_plan_name",
            "purchase_request_person_in_charge_name", "purchase_request_person_in_charge_id",
            "purchase_request_plan_person_in_charge_name", "purchase_request_plan_person_in_charge_id",
            "order_person_in_charge_name", "order_person_in_charge_id",
            "order_plan_person_in_charge_name", "order_plan_person_in_charge_id",
            "order_date_time", "order_plan_date_time",
            "delivery_date", "delivery_plan_date", "service_header_id", "service_plan_id",
            "service_name", "service_plan_name", "order_local_date", "order_plan_local_date", "delivery_local_date",
            "delivery_plan_local_date", "order_dept_in_charge_id", "order_plan_dept_in_charge_id",
            "pr_order_search_trn_id", "order_no", "purchase_request_no", "purpose_of_purchase", "project_name");

    /** The Search Fetch Field List for the detail view. */
    public static final ImmutableList<String> SEARCH_FETCH_DETAIL_FIELD_LIST = ImmutableList.of(
            "pr_order_search_trn_id", "sub_string_key",
            "order_id", "order_type",
            "order_title", "order_status", "order_status_name",
            "plan_order_title", "plan_order_status", "plan_order_status_name",
            "order_person_in_charge_id", "order_person_in_charge_name",
            "plan_order_person_in_charge_id", "plan_order_person_in_charge_name",
            "order_date_time", "order_local_date",
            "plan_order_date_time", "plan_order_local_date",
            "delivery_date", "delivery_local_date",
            "plan_delivery_date", "plan_delivery_local_date",
            "service_header_id", "service_name",
            "plan_service_header_id", "plan_service_name",
            "item_name", "quantity", "unit_name", "unit_price", "cost_type_name",
            "plan_item_name", "plan_quantity", "plan_unit_name", "plan_unit_price", "plan_cost_type_name",
            "order_no", "purchase_request_no", "purpose_of_purchase", "project_name");

    /** The Constant PC_POMT_DELIVERYDATETODAY. */
    public static final String PC_POMT_DELIVERYDATETODAY = "PC.POMT.deliveryDateToday";

    /** The Constant PC_POMT_DELIVERY_DATE_ONE_MONTH. */
    public static final String PC_POMT_DELIVERY_DATE_ONE_MONTH = "PC.POMT.deliveryDateOneMonth";

    /** The Constant PC_POMT_DELIVERYDATE_THREE_MONTH. */
    public static final String PC_POMT_DELIVERYDATE_THREE_MONTH = "PC.POMT.deliveryDateThreeMonth";

    /** The Constant PC_POMT_DELIVERYDATE_THREE_MONTH. */
    public static final int DELIVERYDATE_THREE_MONTH_FROM_TODAY = 3;

    /** The Constant PC_POMT_DELIVERYALL. */
    public static final String PC_POMT_DELIVERYALL = "PC.POMT.deliveryAll";

    /** The Constant TAG_OPEN. */
    public static final String TAG_OPEN = "<>";

    /** The Constant TAG_CLOSE. */
    public static final String TAG_CLOSE = "</>";

    /** The Constant HIGHLIGHT_TAG_START. */
    public static final String HIGHLIGHT_TAG_START = "<highlight>";

    /** The Constant HIGHLIGHT_TAG_END. */
    public static final String HIGHLIGHT_TAG_END = "</highlight>";
    /** The Constant OTHER. */
    public static final String OTHER = "OTHER";
    /** The Constant ORDER_STATUS_JSON. */
    public static final String ORDER_STATUS_JSON = "order_status";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String ORDER_STATUS_NAME_JSON = "order_status_name";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String ORDER_TYPE = "order_type";
    /** The Constant ORDER_STATUS_JSON. */
    public static final String ORDER_TITLE = "order_title";
    /** The Constant ORDER_STATUS_JSON. */
    public static final String AC = "ac";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String SENDING_METHOD_NAME = "sending_method_name";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String CURRENTCOUNT = "currentCount";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String SERVICE_NAME = "service_name";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String ORDER_DATE_JSON = "order_date_time";

    /** The Constant ORDER_STATUS_JSON. */
    public static final String DELIVERY_DATE_JSON = "delivery_date";
    /** The Constant ORDER_STATUS_JSON. */
    public static final String PERSON_IN_CHARGE = "person_in_charge";
    /** The Constant ORDER_STATUS_JSON. */
    public static final String ORDER_PERSON_IN_CHARGE = "order_person_in_charge_name";
    /** The Constant ORDER_PERSON_IN_CHARGE_ID. */
    public static final String ORDER_PERSON_IN_CHARGE_ID = "order_person_in_charge_id";
    /** The Constant SEARCH. */
    public static final String SEARCH = "search";

    /** The Constant SEARCH. */
    public static final String SERVICE_HEADER_ID = "service_header_id";

    /** The Constant ORDER_EMPLOYEE_NAME. */
    public static final String ORDER_EMPLOYEE_NAME = "order_employee_name";
    /** The Constant ORDER_LOCAL_DATE. */
    public static final String ORDER_LOCAL_DATE = "order_local_date";

    /** The Constant DELIVERY_LOCAL_DATE. */
    public static final String DELIVERY_LOCAL_DATE = "delivery_local_date";

    /** The Constant TOTAL_COUNT_STATUS_LABEL. */
    public static final String TOTAL_COUNT_STATUS_LABEL = "total-count-status-label";
    /** The Constant ZONEDATEKEY. */
    public static final String ZONEDATEKEY = "zonedatekey";

    /** The Constant SUB_KEY. */
    public static final char SUB_KEY = '_';

    /** The Constant SCM_PROCUREMENT_PURCHASE_GLOBAL_SEARCH. */
    public static final String SCM_PROCUREMENT_PURCHASE_ORDER_SEARCH = "SCM_PROCUREMENT_PURCHASE_ORDER_SEARCH_STATUS";

    /** Used for detail view of 'Find Ordering cases' of Order management */
    public static final String SCM_PROCUREMENT_PURCHASE_ORDER_DETAIL_SEARCH = "SCM_PROCUREMENT_PURCHASE_ORDER_DETAIL_SEARCH";

    /** The Constant STATUS_INITIAL_FACET_HEADER_LIST. */
    public static final ImmutableList<String> STATUS_INITIAL_FACET_HEADER_LIST = ImmutableList.of(
            "PC.POMT.orderStatus",
            "PC.POMT.serviceName",
            "PC.POMT.orderDate",
            "PC.POMT.deliveryDate",
            "PC.POMT.personInCharge",
            "Amount of Money");

    /** The Constant PURCHASE_FACET_STATUS. */
    public static final String PURCHASE_FACET_STATUS = "facet_status";

    /** The Constant FIND_ORDER_FACET_SIMA_GRID. */
    public static final String FIND_ORDER_FACET_SIMA_GRID = "find-order-facet-sima-grid";

    /** The Constant FIND_ORDER_FACET_DETAIL_SIMA_GRID. */
    public static final String FIND_ORDER_FACET_DETAIL_SIMA_GRID = "find-order-facet-detail-sima-grid";
    /** The Constant FIND_ORDER_FACET_INBOX_LIST */
    public static final String FIND_ORDER_FACET_INBOX_LIST = "find-order-facet-inbox-list";

    /** The Constant FIND_ORDER_FACET_DETAIL_INBOX_LIST. */
    public static final String FIND_ORDER_FACET_DETAIL_INBOX_LIST = "find-order-facet-detail-inbox-list";

    /** The Constant TOTAL_COUNT_FACET_STATUS_LABEL. */
    public static final String TOTAL_COUNT_FACET_STATUS_LABEL = "total-count-facet-status-label";

    /** The Constant DISPLAY_ROW. */
    public static final String DISPLAY_ROW = "display-row";

    /** The Constant STRING_ZERO. */
    public static final String STRING_ZERO = "0";

    /** The Constant STRING_ONE. */
    public static final String STRING_ONE = "1";

    /** The Constant STRING_TWO. */
    public static final String STRING_TWO = "2";

    /** The Constant SUB_SYSTEM_ORDER. */
    public static final String SUB_SYSTEM_ORDER = "ORDER";

    /** The Constant DELIVERY_DATE_VALUE. */
    public static final String VENDOR_PRINT_ORDER_INBOX_LIST = "vendor-print-order-inbox-list";

    /** The Constant PRINT_ORDER_INBOX_LIST_NAME. */
    public static final String VENDOR_PRINT_ORDER_INBOX_LIST_NAME = "vendorPrintOrderInboxList";

    /** The Constant DOC. */
    public static final String DOC_SEARCH = "doc";

    /** The Constant FILTER_ROW. */
    public static final String FILTER_ROW = "filter-row";

    /** The Constant GREY_COLOR. */
    public static final String GREY_COLOR = "gray";

    /** The Constant SUCCESS_TEXT_COLOR. */
    public static final String SUCCESS_TEXT_COLOR = "#00B19D";

    /** The Constant WARNING_TEXT_COLOR. */
    public static final String WARNING_TEXT_COLOR = "#F4B142";

    /** The Constant DANGER_TEXT_COLOR. */
    public static final String DANGER_TEXT_COLOR = "#E91E63";

    /** The Constant INFO_TEXT_COLOR. */
    public static final String INFO_TEXT_COLOR = "#4285F4";

    /** The Constant dateFormatter. */
    public static final String dateFormatter = "yyyy/M/d";

    /** The Constant ALERT. */
    public static final String ALERT = "ALERT";

    /** The Constant ORDER_ATP_ANSWER_INCLUDES_SOME_PROBLEMS */
    public static final String ORDER_ATP_ANSWER_INCLUDES_SOME_PROBLEMS = "ORDER_ATP_ANSWER_INCLUDES_SOME_PROBLEMS";

    /** The Constant PC_POMT_SEARCHRESULT. */
    public static final String PC_POMT_SEARCHRESULT = "PC.POMT.searchResult";

    /** The Constant PC_POMT_FILTERSEARCHRESULT. */
    public static final String PC_POMT_FILTERSEARCHRESULT = "PC.POMT.filterSearchResult";

    /** The Constant TOTAL_COUNT_FILTER_STATUS_LABEL. */
    public static final String TOTAL_COUNT_FILTER_STATUS_LABEL = "total-count-filter-status-label";

    /** The Constant WAITING_FOR_RECEIVING. */
    public static final String WAITING_FOR_RECEIVING = "WAITING_FOR_RECEIVING";

    /** The Constant STATS_ROW. */
    public static final String STATS_ROW = "stats-row";

    /** The Constant STATS_FILTER_ROW. */
    public static final String STATS_FILTER_ROW = "stats-filter-row";

    /** The Constant DETAIL_APPROVAL_CIRCUMSTANCES. */
    public static final String DETAIL_APPROVAL_CIRCUMSTANCES = "PC.POMT.detailApprovalCircumstance";

    /** The Constant ORDER_DETAIL_FORM_JASPER. */
    public static final String ORDER_DETAIL_FORM_JASPER = "OrderDetailForm";

    /** The Constant PURPOSE_OF_PURCHASE_REPORT. */
    public static final String PURPOSE_OF_PURCHASE_REPORT = "purposeOfPurchase";

    /** The Constant DESIRED_DELIVERY_DATE_TIME_REPORT. */
    public static final String DESIRED_DELIVERY_DATE_TIME_REPORT = "desiredDeliveryDateTime";

    /** The Constant DESIRED_DELIVERY_TIME_REPORT. */
    public static final String DESIRED_DELIVERY_TIME_REPORT = "desiredDeliveryTime";

    /** The Constant PROJECT_NAME_REPORT. */
    public static final String PROJECT_NAME_REPORT = "projectName";

    /** The Constant PURCHASE_REQUEST_NO_REPORT. */
    public static final String PURCHASE_REQUEST_NO_REPORT = "purchaseRequestNo";

    /** The Constant PURCHASE_REQUESTER_DIVISION_NAME_REPORT. */
    public static final String PURCHASE_REQUESTER_DIVISION_NAME_REPORT = "purchaseRequesterDivisionName";

    /** The Constant PURCHASE_REQUESTER_OFFICE_NAME_REPORT. */
    public static final String PURCHASE_REQUESTER_OFFICE_NAME_REPORT = "purchaseRequesterOfficeName";

    /** The Constant PURCHASE_REQUESTER_NAME_REPORT. */
    public static final String PURCHASE_REQUESTER_NAME_REPORT = "purchaseRequesterName";

    /** The Constant INTERNAL_REMARKS_REPORT. */
    public static final String INTERNAL_REMARKS_REPORT = "internalRemarks";

    /** The Constant PREPAYMENT_EXPENCE_TYPE_NAME_REPORT. */
    public static final String PREPAYMENT_EXPENCE_TYPE_NAME_REPORT = "prepaymentExpenceTypeName";

    /** The Constant PREPAYMENT_ACCOUNT_TITLE_NAME_REPORT. */
    public static final String PREPAYMENT_ACCOUNT_TITLE_NAME_REPORT = "prepaymentAccountTitleName";

    /** The Constant BURDERN_DEPARTMENT_NAME_REPORT. */
    public static final String BURDERN_DEPARTMENT_NAME_REPORT = "burdernDepartmentName";

    /** The Constant BUDGET_INFORMATION_NAME_REPORT. */
    public static final String BUDGET_INFORMATION_NAME_REPORT = "budgetInformationName";

    /** The Constant COST_TYPE_NAME_REPORT. */
    public static final String COST_TYPE_NAME_REPORT = "costTypeName";

    /** The Constant INSTALLATION_LOCATION_NAME_REPORT. */
    public static final String INSTALLATION_LOCATION_NAME_REPORT = "installationLocationName";

    /** The Constant ASSET_CLASSIFICATION_NAME_REPORT. */
    public static final String ASSET_CLASSIFICATION_NAME_REPORT = "assetClassificationName";

    /** The Constant SENDING_METHOD_NAME_REPORT. */
    public static final String SENDING_METHOD_NAME_REPORT = "sendingMethodName";

    /** The Constant DELIVERABLE_POSTAL_CODE_REPORT. */
    public static final String DELIVERABLE_POSTAL_CODE_REPORT = "deliverablePostalCode";

    /** The Constant DELIVERY_ADDRESS_REPORT. */
    public static final String DELIVERY_ADDRESS_REPORT = "deliveryAddress";

    /** The Constant DELIVERY_PLACE_NAME_REPORT. */
    public static final String DELIVERY_PLACE_NAME_REPORT = "deliveryPlaceName";

    /** The Constant DELIVERY_WAREHOUSE_NAME_REPORT. */
    public static final String DELIVERY_WAREHOUSE_NAME_REPORT = "deliveryWarehouseName";

    /** The Constant ACCEPTANCE_DEPARTMENT_NAME_REPORT. */
    public static final String ACCEPTANCE_DEPARTMENT_NAME_REPORT = "acceptanceDepartmentName";

    /** The Constant ACCEPTANCE_EMPLOYEE_NAME_REPORT. */
    public static final String ACCEPTANCE_EMPLOYEE_NAME_REPORT = "acceptanceEmployeeName";

    /** The Constant ACCEPTANCE_EMPLOYEE_PHONE_NUMBER_REPORT. */
    public static final String ACCEPTANCE_EMPLOYEE_PHONE_NUMBER_REPORT = "acceptanceEmployeePhoneNumber";

    /** The Constant ACCEPTANCE_EMPLOYEE_MAIL_ADDRESS_REPORT. */
    public static final String ACCEPTANCE_EMPLOYEE_MAIL_ADDRESS_REPORT = "acceptanceEmployeeMailAddress";

    /** The Constant ACCEPTANCE_EMPLOYEE_FAX_NUMBER_REPORT. */
    public static final String ACCEPTANCE_EMPLOYEE_FAX_NUMBER_REPORT = "acceptanceEmployeeFaxNumber";

    /** The Constant ACCEPTANCE_DATE_REPORT. */
    public static final String ACCEPTANCE_DATE_REPORT = "acceptanceDate";

    /** The Constant DESIRED_DELIVERY_DATE_START_REPORT. */
    public static final String DESIRED_DELIVERY_DATE_START_REPORT = "desiredDeliveryDateStart";

    /** The Constant DESIRED_DELIVERY_DATE_END_REPORT. */
    public static final String DESIRED_DELIVERY_DATE_END_REPORT = "desiredDeliveryDateEnd";

    /** The Constant PACKING_NAME_REPORT. */
    public static final String PACKING_NAME_REPORT = "packingName";

    /** The Constant DELIVERY_CONDITION_NAME_REPORT. */
    public static final String DELIVERY_CONDITION_NAME_REPORT = "deliveryConditionName";

    /** The Constant MEMO_AT_DELIVERY_DATE_ANSWER_REPORT. */
    public static final String MEMO_AT_DELIVERY_DATE_ANSWER_REPORT = "memoAtDeliveryDateAnswer";

    /** The Constant NOTES_FROM_ORDERER_REPORT. */
    public static final String NOTES_FROM_ORDERER_REPORT = "notesFromOrderer";

    /** The Constant RESULT_ASSESMENT_METHOD_REPORT. */
    public static final String RESULT_ASSESMENT_METHOD_REPORT = "resultAssesmentMethod";

    /** The Constant DESIRED_ORDER_DATE_REPORT. */
    public static final String DESIRED_ORDER_DATE_REPORT = "desiredOrderDate";

    /** The Constant CONTRACT_CLASSIFICATION_REPORT. */
    public static final String CONTRACT_CLASSIFICATION_REPORT = "contractClassification";

    /** The Constant SEPARATE_CLASSIFICATION_REPORT. */
    public static final String SEPARATE_CLASSIFICATION_REPORT = "separateClassification";

    /** The Constant CONSTRUCTION_BUSINESS_LICENSE_NUMBER_DATE_REPORT. */
    public static final String CONSTRUCTION_BUSINESS_LICENSE_NUMBER_DATE_REPORT = "constructionBusinessLicenseNumberDate";

    /** The Constant ORDER_REVISION_NUMBER_REPORT. */
    public static final String ORDER_REVISION_NUMBER_REPORT = "orderRevisionNumber";

    /** The Constant ORDER_DEPARTMENT_NAME_REPORT. */
    public static final String ORDER_DEPARTMENT_NAME_REPORT = "orderDepartmentName";

    /** The Constant ORDER_EMPLOYEE_NAME_REPORT. */
    public static final String ORDER_EMPLOYEE_NAME_REPORT = "orderEmployeeName";

    /** The Constant ORIGINAL_ORDER_DEPARTMENT_NAME_REPORT. */
    public static final String ORIGINAL_ORDER_DEPARTMENT_NAME_REPORT = "originalOrderDepartmentName";

    /** The Constant ORIGINAL_ORDER_EMPLOYEE_NAME_REPORT. */
    public static final String ORIGINAL_ORDER_EMPLOYEE_NAME_REPORT = "originalOrderEmployeeName";

    /** The Constant ORDER_TITLE_REPORT. */
    public static final String ORDER_TITLE_REPORT = "orderTitle";

    /** The Constant REPRESENTATIVE_IN_SUPPLIER_NAME_REPORT. */
    public static final String REPRESENTATIVE_IN_SUPPLIER_NAME_REPORT = "representativeInSupplierName";

    /** The Constant REPRESENTATIVE_IN_SUPPLIER_PHONE_NUMBER_REPORT. */
    public static final String REPRESENTATIVE_IN_SUPPLIER_PHONE_NUMBER_REPORT = "representativeInSupplierPhoneNumber";

    /** The Constant REPRESENTATIVE_IN_SUPPLIER_FAX_NUMBER_REPORT. */
    public static final String REPRESENTATIVE_IN_SUPPLIER_FAX_NUMBER_REPORT = "representativeInSupplierFaxNumber";

    /** The Constant REPERESENTATIVE_SUPPLIER_MAIL_ADDRESS_REPORT. */
    public static final String REPERESENTATIVE_SUPPLIER_MAIL_ADDRESS_REPORT = "reperesentativeSupplierMailAddress";

    /** The Constant PAYMENT_TERMS_NAME_REPORT. */
    public static final String PAYMENT_TERMS_NAME_REPORT = "paymentTermsName";

    /** The Constant CONTRACT_CONTINUOUS_MONTH_COUNT_REPORT. */
    public static final String CONTRACT_CONTINUOUS_MONTH_COUNT_REPORT = "contractContinuousMonthCount";

    /** The Constant TOTAL_PAYMENT_COUNT_REPORT. */
    public static final String TOTAL_PAYMENT_COUNT_REPORT = "totalPaymentCount";

    /** The Constant CANCELLATION_AVAILABILITY_REPORT. */
    public static final String CANCELLATION_AVAILABILITY_REPORT = "cancellationAvailability";

    /** The Constant CANCELLATION_NOT_AVAILABLE_TERM_START_DATE_REPORT. */
    public static final String CANCELLATION_NOT_AVAILABLE_TERM_START_DATE_REPORT = "cancellationNotAvailableTermStartDate";

    /** The Constant CANCELLATION_NOT_AVAILABLE_TERM_END_DATE_REPORT. */
    public static final String CANCELLATION_NOT_AVAILABLE_TERM_END_DATE_REPORT = "cancellationNotAvailableTermEndDate";

    /** The Constant CANCELLATION_NOT_AVAILABLE_MONTH_COUNT_REPORT. */
    public static final String CANCELLATION_NOT_AVAILABLE_MONTH_COUNT_REPORT = "cancellationNotAvailableMonthCount";

    /** The Constant MEMO_AT_ORDER_REPORT. */
    public static final String MEMO_AT_ORDER_REPORT = "memoAtOrder";

    /** The Constant SCHEDULED_PAYMENT_BY_RESULT_COUNT_REPORT. */
    public static final String SCHEDULED_PAYMENT_BY_RESULT_COUNT_REPORT = "scheduledPaymentByResultCount";

    /** The Constant TOTAL_DISCOUNT_AMOUNT_REPORT. */
    public static final String TOTAL_DISCOUNT_AMOUNT_REPORT = "totalDiscountAmount";

    /** The Constant TOTAL_COMSUMPTION_TAX_AMOUNT_REPORT. */
    public static final String TOTAL_COMSUMPTION_TAX_AMOUNT_REPORT = "totalComsumptionTaxAmount";

    /** The Constant TOTAL_TAX_INCLUDED_AMOUNT_REPORT. */
    public static final String TOTAL_TAX_INCLUDED_AMOUNT_REPORT = "totalTaxIncludedAmount";

    /** The Constant TOTAL_TAX_EXCLUDED_AMOUNT_REPORT. */
    public static final String TOTAL_TAX_EXCLUDED_AMOUNT_REPORT = "totalTaxExcludedAmount";

    /** The Constant ORDER_STATUS. */
    public static final String ORDER_STATUS = "orderStatus";

    /** The Constant INITIAL_PAYMENT_TAX_EXCLUDED_AMOUNT_REPORT. */
    public static final String INITIAL_PAYMENT_TAX_EXCLUDED_AMOUNT_REPORT = "initialPaymentTaxExcludedAmount";

    /** The Constant INITIAL_PAYMENT_TAX_INCLUDED_AMOUNT_REPORT. */
    public static final String INITIAL_PAYMENT_TAX_INCLUDED_AMOUNT_REPORT = "initialPaymentTaxIncludedAmount";

    /** The Constant INITIAL_PAYMENT_COMSUMPTION_TAX_AMOUNT_REPORT. */
    public static final String INITIAL_PAYMENT_COMSUMPTION_TAX_AMOUNT_REPORT = "initialPaymentComsumptionTaxAmount";

    /** The Constant MONTHLY_PAYMENT_TAX_EXCLUDED_AMOUNT_REPORT. */
    public static final String MONTHLY_PAYMENT_TAX_EXCLUDED_AMOUNT_REPORT = "monthlyPaymentTaxExcludedAmount";

    /** The Constant MONTHLY_PAYMENT_TAX_INCLUDED_AMOUNT_REPORT. */
    public static final String MONTHLY_PAYMENT_TAX_INCLUDED_AMOUNT_REPORT = "monthlyPaymentTaxIncludedAmount";

    /** The Constant MONTHLY_PAYMENT_COMSUMPTION_TAX_AMOUNT_REPORT. */
    public static final String MONTHLY_PAYMENT_COMSUMPTION_TAX_AMOUNT_REPORT = "monthlyPaymentComsumptionTaxAmount";

    /** The Constant FINAL_PAYMENT_TAX_INCLUDED_AMOUNT_REPORT. */
    public static final String FINAL_PAYMENT_TAX_INCLUDED_AMOUNT_REPORT = "finalPaymentTaxIncludedAmount";

    /** The Constant FINAL_PAYMENT_TAX_EXCLUDED_AMOUNT_REPORT. */
    public static final String FINAL_PAYMENT_TAX_EXCLUDED_AMOUNT_REPORT = "finalPaymentTaxExcludedAmount";

    /** The Constant FINAL_PAYMENT_COMSUMPTION_TAX_AMOUNT_REPORT. */
    public static final String FINAL_PAYMENT_COMSUMPTION_TAX_AMOUNT_REPORT = "finalPaymentComsumptionTaxAmount";

    /** The Constant MONTHLY_MAINTENANCE_FEE_REPORT. */
    public static final String MONTHLY_MAINTENANCE_FEE_REPORT = "monthlyMaintenanceFee";

    /** The Constant TOTAL_MAINTENANCE_FEE_REPORT. */
    public static final String TOTAL_MAINTENANCE_FEE_REPORT = "totalMaintenanceFee";

    /** The Constant RESIDUAL_VALUE_GUARANTEES_EXCLUDING_TAX_REPORT. */
    public static final String RESIDUAL_VALUE_GUARANTEES_EXCLUDING_TAX_REPORT = "residualValueGuaranteesExcludingTax";

    /** The Constant HAS_OWNERSHIP_TRANSFER_PROVISION_REPORT. */
    public static final String HAS_OWNERSHIP_TRANSFER_PROVISION_REPORT = "hasOwnershipTransferProvision";

    /** The Constant IS_SPECIAL_SPECIFICATION_PROPERTY_REPORT. */
    public static final String IS_SPECIAL_SPECIFICATION_PROPERTY_REPORT = "isSpecialSpecificationProperty";

    /** The Constant IS_LEASEBACK_TRANSACTION_REPORT. */
    public static final String IS_LEASEBACK_TRANSACTION_REPORT = "isLeasebackTransaction";

    /** The Constant LEASE_TRANSACTION_CLASSIFICATION_ID_REPORT. */
    public static final String LEASE_TRANSACTION_CLASSIFICATION_ID_REPORT = "leaseTransactionClassificationId";

    /** The Constant LEASE_TRANSCATION_CLASSIFICATION_NAME_REPORT. */
    public static final String LEASE_TRANSCATION_CLASSIFICATION_NAME_REPORT = "leaseTranscationClassificationName";

    /** The Constant LEASE_ACCOUNTING_PROCESSING_TYPE_REPORT. */
    public static final String LEASE_ACCOUNTING_PROCESSING_TYPE_REPORT = "leaseAccountingProcessingType";

    /** The Constant PREPAYED_AMOUNT_REPORT. */
    public static final String PREPAYED_AMOUNT_REPORT = "prepayedAmount";

    /** The Constant PREPAYMENT_PAYMENT_TERM_NAME_REPORT. */
    public static final String PREPAYMENT_PAYMENT_TERM_NAME_REPORT = "prepaymentPaymentTermName";

    /** The Constant INSPECTION_DEPARTMENT_NAME_REPORT. */
    public static final String INSPECTION_DEPARTMENT_NAME_REPORT = "inspectionDepartmentName";

    /** The Constant INSPECTION_EMPLOYEE_NAME_REPORT. */
    public static final String INSPECTION_EMPLOYEE_NAME_REPORT = "inspectionEmployeeName";

    /** The Constant PURCHASE_ORDER_MATCHING_DEPARTMENT_NAME_REPORT. */
    public static final String PURCHASE_ORDER_MATCHING_DEPARTMENT_NAME_REPORT = "purchaseOrderMatchingDepartmentName";

    /** The Constant PURCHASE_ORDER_MATCHING_EMPLOYEE_NAME_REPORT. */
    public static final String PURCHASE_ORDER_MATCHING_EMPLOYEE_NAME_REPORT = "purchaseOrderMatchingEmployeeName";

    /** The Constant ORDER_RECEIVING_NUMBER_REPORT. */
    public static final String ORDER_RECEIVING_NUMBER_REPORT = "orderReceivingNumber";

    /** The Constant APPLY_DATE_REPORT. */
    public static final String APPLY_DATE_REPORT = "applyDate";

    /** The Constant APPROVAL_DATE_REPORT. */
    public static final String APPROVAL_DATE_REPORT = "approvalDate";

    /** The Constant LAST_MODIFIED_REPORT. */
    public static final String LAST_MODIFIED_REPORT = "lastModified";

    /** The Constant PURCHASE_REQUEST_APPLY_DATE_REPORT. */
    public static final String PURCHASE_REQUEST_APPLY_DATE_REPORT = "purchaseRequestApplyDate";

    /** The Constant QUANTITY_REPORT_DETAIL. */
    public static final String QUANTITY_REPORT_DETAIL = "quantityReportDetail";

    /** The Constant UNIT_PRICE_REPORT_DETAIL. */
    public static final String UNIT_PRICE_REPORT_DETAIL = "unitPriceReportDetail";

    /** The Constant CONSUMPTION_TAX_RATE_REPORT_DETAIL. */
    public static final String CONSUMPTION_TAX_RATE_REPORT_DETAIL = "consumptionTaxRateReportDetail";

    /** The Constant TAX_INCLUDED_AMOUNT_REPORT_DETAIL. */
    public static final String TAX_INCLUDED_AMOUNT_REPORT_DETAIL = "taxIncludedAmountReportDetail";

    /** The Constant TAX_EXCLUDED_AMOUNT_REPORT_DETAIL. */
    public static final String TAX_EXCLUDED_AMOUNT_REPORT_DETAIL = "taxExcludedAmountReportDetail";

    /** The Constant CONSUMPTION_TAX_AMOUNT_REPORT_DETAIL. */
    public static final String CONSUMPTION_TAX_AMOUNT_REPORT_DETAIL = "consumptionTaxAmountReportDetail";

    /** The Constant ANSWERED_QUANTITY_REPORT_DETAIL. */
    public static final String ANSWERED_QUANTITY_REPORT_DETAIL = "answeredQuantityReportDetail";

    /** The Constant ORDER_DETAIL_NO_REPORT_DETAIL. */
    public static final String ORDER_DETAIL_NO_REPORT_DETAIL = "orderDetailNoReportDetail";

    /** The Constant ORDER_REVISION_NUMBER_REPORT_DETAIL. */
    public static final String ORDER_REVISION_NUMBER_REPORT_DETAIL = "orderRevisionNumberReportDetail";

    /** The Constant INNER_REVISION_NUMBER_REPORT_DETAIL. */
    public static final String INNER_REVISION_NUMBER_REPORT_DETAIL = "innerRevisionNumberReportDetail";

    /** The Constant IS_PARTIAL_DELIVERY_AVAILABLE_REPORT_DETAIL. */
    public static final String IS_PARTIAL_DELIVERY_AVAILABLE_REPORT_DETAIL = "isPartialDeliveryAvailableReportDetail";

    /** The Constant IS_SUBSTITUTE_AVAILABLE_REPORT_DETAIL. */
    public static final String IS_SUBSTITUTE_AVAILABLE_REPORT_DETAIL = "isSubstituteAvailableReportDetail";

    /** The Constant INSPECTION_DEPARTMENT_ID_REPORT_DETAIL. */
    public static final String INSPECTION_DEPARTMENT_ID_REPORT_DETAIL = "inspectionDepartmentIdReportDetail";

    /** The Constant ITEM_CLASSIFICATION_NAME_REPORT_DETAIL. */
    public static final String ITEM_CLASSIFICATION_NAME_REPORT_DETAIL = "itemClassificationNameReportDetail";

    /** The Constant PAYMENT_TERMS_NAME_REPORT_DETAIL. */
    public static final String PAYMENT_TERMS_NAME_REPORT_DETAIL = "paymentTermsNameReportDetail";

    /** The Constant PROJECT_NAME_REPORT_DETAIL. */
    public static final String PROJECT_NAME_REPORT_DETAIL = "projectNameReportDetail";

    /** The Constant BUDGET_INFORMATION_NAME_REPORT_DETAIL. */
    public static final String BUDGET_INFORMATION_NAME_REPORT_DETAIL = "budgetInformationNameReportDetail";

    /** The Constant COST_CLASSIFICATION_NAME_REPORT_DETAIL. */
    public static final String COST_CLASSIFICATION_NAME_REPORT_DETAIL = "costClassificationNameReportDetail";

    /** The Constant COST_TYPE_NAME_REPORT_DETAIL. */
    public static final String COST_TYPE_NAME_REPORT_DETAIL = "costTypeNameReportDetail";

    /** The Constant BURDEN_DEPARTMENT_NAME_REPORT_DETAIL. */
    public static final String BURDEN_DEPARTMENT_NAME_REPORT_DETAIL = "burdenDepartmentNameReportDetail";

    /** The Constant INSTALLATION_LOCATION_NAME_REPORT_DETAIL. */
    public static final String INSTALLATION_LOCATION_NAME_REPORT_DETAIL = "installationLocationNameReportDetail";

    /** The Constant ASSET_CLASSIFICATION_NAME_REPORT_DETAIL. */
    public static final String ASSET_CLASSIFICATION_NAME_REPORT_DETAIL = "assetClassificationNameReportDetail";

    /** The Constant ACCOUNT_TITLE_NAME_REPORT_DETAIL. */
    public static final String ACCOUNT_TITLE_NAME_REPORT_DETAIL = "accountTitleNameReportDetail";

    /** The Constant DELIVERY_PLACE_NAME_REPORT_DETAIL. */
    public static final String DELIVERY_PLACE_NAME_REPORT_DETAIL = "deliveryPlaceNameReportDetail";

    /** The Constant DELIVERY_CONDITION_NAME_REPORT_DETAIL. */
    public static final String DELIVERY_CONDITION_NAME_REPORT_DETAIL = "deliveryConditionNameReportDetail";

    /** The Constant PACKING_NAME_REPORT_DETAIL. */
    public static final String PACKING_NAME_REPORT_DETAIL = "packingNameReportDetail";

    /** The Constant DELIVERY_WAREHOUSE_NAME_REPORT_DETAIL. */
    public static final String DELIVERY_WAREHOUSE_NAME_REPORT_DETAIL = "deliveryWarehouseNameReportDetail";

    /** The Constant ACCEPTANCE_DEPARTMENT_NAME_REPORT_DETAIL. */
    public static final String ACCEPTANCE_DEPARTMENT_NAME_REPORT_DETAIL = "acceptanceDepartmentNameReportDetail";

    /** The Constant INSPECTION_DEPARTMENT_NAME_REPORT_DETAIL. */
    public static final String INSPECTION_DEPARTMENT_NAME_REPORT_DETAIL = "inspectionDepartmentNameReportDetail";

    /** The Constant INSPECTION_EMPLOYEE_NAME_REPORT_DETAIL. */
    public static final String INSPECTION_EMPLOYEE_NAME_REPORT_DETAIL = "inspectionEmployeeNameReportDetail";

    /** The Constant PURCHASE_ORDER_MATCHING_DEPARTMENT_NAME_REPORT_DETAIL. */
    public static final String PURCHASE_ORDER_MATCHING_DEPARTMENT_NAME_REPORT_DETAIL = "purchaseOrderMatchingDepartmentNameReportDetail";

    /** The Constant PURCHASE_ORDER_MATCHING_EMPLOYEE_NAME_REPORT_DETAIL. */
    public static final String PURCHASE_ORDER_MATCHING_EMPLOYEE_NAME_REPORT_DETAIL = "purchaseOrderMatchingEmployeeNameReportDetail";

    /** The Constant PURCHASE_PROCESS_TYPE_REPORT_DETAIL. */
    public static final String PURCHASE_PROCESS_TYPE_REPORT_DETAIL = "purchaseProcessTypeReportDetail";

    /** The Constant ITEM_NO_REPORT_DETAIL. */
    public static final String ITEM_NO_REPORT_DETAIL = "itemNoReportDetail";

    /** The Constant ITEM_NAME_REPORT_DETAIL. */
    public static final String ITEM_NAME_REPORT_DETAIL = "itemNameReportDetail";

    /** The Constant ITEM_NAME_SUPPLEMENT_REPORT_DETAIL. */
    public static final String ITEM_NAME_SUPPLEMENT_REPORT_DETAIL = "itemNameSupplementReportDetail";

    /** The Constant SPECIFICATION_REPORT_DETAIL. */
    public static final String SPECIFICATION_REPORT_DETAIL = "specificationReportDetail";

    /** The Constant SPECIFICATION_SUPPLEMENT_REPORT_DETAIL. */
    public static final String SPECIFICATION_SUPPLEMENT_REPORT_DETAIL = "specificationSupplementReportDetail";

    /** The Constant MANUFACTURER_MODEL_NUMBER_REPORT_DETAIL. */
    public static final String MANUFACTURER_MODEL_NUMBER_REPORT_DETAIL = "manufacturerModelNumberReportDetail";

    /** The Constant MANUFACTURER_NAME_REPORT_DETAIL. */
    public static final String MANUFACTURER_NAME_REPORT_DETAIL = "manufacturerNameReportDetail";

    /** The Constant UNIT_NAME_REPORT_DETAIL. */
    public static final String UNIT_NAME_REPORT_DETAIL = "unitNameReportDetail";

    /** The Constant TAX_CLASSIFICATION_REPORT_DETAIL. */
    public static final String TAX_CLASSIFICATION_REPORT_DETAIL = "taxClassificationReportDetail";

    /** The Constant ORDER_TITLE_REPORT_DETAIL. */
    public static final String ORDER_TITLE_REPORT_DETAIL = "orderTitleReportDetail";

    /** The Constant ORDER_MEMO_REPORT_DETAIL. */
    public static final String ORDER_MEMO_REPORT_DETAIL = "orderMemoReportDetail";

    /** The Constant DETAIL_MEMO_REPORT_DETAIL. */
    public static final String DETAIL_MEMO_REPORT_DETAIL = "detailMemoReportDetail";

    /** The Constant DETAIL_MEMO_SUPPLEMENT_REPORT_DETAIL. */
    public static final String DETAIL_MEMO_SUPPLEMENT_REPORT_DETAIL = "detailMemoSupplementReportDetail";

    /** The Constant INHOUSE_DETAIL_MEMO_REPORT_DETAIL. */
    public static final String INHOUSE_DETAIL_MEMO_REPORT_DETAIL = "inhouseDetailMemoReportDetail";

    /** The Constant PURPOSE_OF_PURCHASE_REPORT_DETAIL. */
    public static final String PURPOSE_OF_PURCHASE_REPORT_DETAIL = "purposeOfPurchaseReportDetail";

    /** The Constant PURCHASE_REQUEST_NO_REPORT_DETAIL. */
    public static final String PURCHASE_REQUEST_NO_REPORT_DETAIL = "purchaseRequestNoReportDetail";

    /** The Constant PURCHASE_REQUESTER_DIVISION_NAME_REPORT_DETAIL. */
    public static final String PURCHASE_REQUESTER_DIVISION_NAME_REPORT_DETAIL = "purchaseRequesterDivisionNameReportDetail";

    /** The Constant PURCHASE_REQUESTER_OFFICE_NAME_REPORT_DETAIL. */
    public static final String PURCHASE_REQUESTER_OFFICE_NAME_REPORT_DETAIL = "purchaseRequesterOfficeNameReportDetail";

    /** The Constant PURCHASE_REQUESTER_NAME_REPORT_DETAIL. */
    public static final String PURCHASE_REQUESTER_NAME_REPORT_DETAIL = "purchaseRequesterNameReportDetail";

    /** The Constant DELIVERABLE_POSTAL_CODE_REPORT_DETAIL. */
    public static final String DELIVERABLE_POSTAL_CODE_REPORT_DETAIL = "deliverablePostalCodeReportDetail";

    /** The Constant DELIVERY_ADDRESS_REPORT_DETAIL. */
    public static final String DELIVERY_ADDRESS_REPORT_DETAIL = "deliveryAddressReportDetail";

    /** The Constant ACCEPTANCE_EMPLOYE_NAME_REPORT_DETAIL. */
    public static final String ACCEPTANCE_EMPLOYE_NAME_REPORT_DETAIL = "acceptanceEmployeNameReportDetail";

    /** The Constant ACCEPTANCE_EMPLOYE_PHONE_NUMBER_REPORT_DETAIL. */
    public static final String ACCEPTANCE_EMPLOYE_PHONE_NUMBER_REPORT_DETAIL = "acceptanceEmployePhoneNumberReportDetail";

    /** The Constant CANCELLATION_NOT_AVAILABLE_TERM_END_DATE_REPORT. */
    public static final String ACCEPTANCE_EMPLOYE_MAIL_ADDRESS_REPORT_DETAIL = "acceptanceEmployeMailAddressReportDetail";

    /** The Constant ACCEPTANCE_EMPLOYE_FAX_NUMBER_REPORT_DETAIL. */
    public static final String ACCEPTANCE_EMPLOYE_FAX_NUMBER_REPORT_DETAIL = "acceptanceEmployeFaxNumberReportDetail";

    /** The Constant NOTES_FROM_ORDERER_REPORT_DETAIL. */
    public static final String NOTES_FROM_ORDERER_REPORT_DETAIL = "notesFromOrdererReportDetail";

    /** The Constant ORDER_RECEIVING_NUMBER_REPORT_DETAIL. */
    public static final String ORDER_RECEIVING_NUMBER_REPORT_DETAIL = "orderReceivingNumberReportDetail";

    /** The Constant CORPORATION_CODE_REPORT_DETAIL. */
    public static final String CORPORATION_CODE_REPORT_DETAIL = "corporationCodeReportDetail";

    /** The Constant CONSUMPTION_TAX_CLASSIFICATION_REPORT_DETAIL. */
    public static final String CONSUMPTION_TAX_CLASSIFICATION_REPORT_DETAIL = "consumptionTaxClassificationReportDetail";

    /** The Constant ORDER_DATE_REPORT_DETAIL. */
    public static final String ORDER_DATE_REPORT_DETAIL = "orderDateReportDetail";

    /** The Constant DESIRED_DELIVERY_DATE_START_REPORT_DETAIL. */
    public static final String DESIRED_DELIVERY_DATE_START_REPORT_DETAIL = "desiredDeliveryDateStartReportDetail";

    /** The Constant DESIRED_DELIVERY_DATE_END_REPORT_DETAIL. */
    public static final String DESIRED_DELIVERY_DATE_END_REPORT_DETAIL = "desiredDeliveryDateEndReportDetail";

    /** The Constant DESIRED_DELIVERY_DATE_TIME_REPORT_DETAIL. */
    public static final String DESIRED_DELIVERY_DATE_TIME_REPORT_DETAIL = "desiredDeliveryDateTimeReportDetail";

    /** The Constant ANSWERED_DATE_REPORT_DETAIL. */
    public static final String ANSWERED_DATE_REPORT_DETAIL = "answeredDateReportDetail";

    /** The Constant PURCHASE_REQUEST_APPLY_DATE_REPORT_DETAIL. */
    public static final String PURCHASE_REQUEST_APPLY_DATE_REPORT_DETAIL = "purchaseRequestApplyDateReportDetail";

    /** The Constant PURCHASE_ORDER_CORRECTION_SERVICE_DEF_ID. */
    public static final String PURCHASE_ORDER_CORRECTION_SERVICE_DEF_ID = "ScmProcurementPurchaseOrderManagement.Correction";

    /** The Constant PURCHASE_ORDER_CORRECTION_SERVICE_ID. */
    public static final String PURCHASE_ORDER_CORRECTION_SERVICE_ID = " ScmProcurementPurchaseOrderManagement.Correction.OrderRegistration";

    /** The Constant PURCHASE_ORDER_CORRECTION_FRAMESET_PATH. */
    public static final String PURCHASE_ORDER_CORRECTION_FRAMESET_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercorrection/purchase-order-correction-framset";

    /** The Constant PURCHASE_ORDER_CORRECTION_INPUT_PATH. */
    public static final String PURCHASE_ORDER_CORRECTION_INPUT_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercorrection/fragment/purchase-order-correction-input";

    /** The Constant PURCHASE_ORDER_CORRECTION_CONFIRM_PATH. */
    public static final String PURCHASE_ORDER_CORRECTION_CONFIRM_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercorrection/fragment/purchase-order-correction-confirm";

    /** The Constant PURCHASE_ORDER_CORRECTION_FINISH_PATH. */
    public static final String PURCHASE_ORDER_CORRECTION_FINISH_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercorrection/fragment/purchase-order-correction-finish";

    /** Cancellation **/
    /** The Constant PURCHASE_ORDER_CANCELLATION_INPUT_PATH. */
    public static final String PURCHASE_ORDER_CANCELLATION_INPUT_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercancellation/fragment/purchase-order-cancellation-input";

    /** The Constant PURCHASE_ORDER_CANCELLATION_CONFIRM_PATH. */
    public static final String PURCHASE_ORDER_CANCELLATION_CONFIRM_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercancellation/fragment/purchase-order-cancellation-confirm";

    /** The Constant PURCHASE_ORDER_CANCELLATION_FINISH_PATH. */
    public static final String PURCHASE_ORDER_CANCELLATION_FINISH_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercancellation/fragment/purchase-order-cancellation-finish";

    /** The Constant PURCHASE_ORDER_CANCELLATION_SERVICE_DEF_ID. */
    public static final String PURCHASE_ORDER_CANCELLATION_SERVICE_DEF_ID = "ScmProcurementPurchaseOrderManagement.Cancellation";

    /** The Constant PURCHASE_ORDER_CANCELLATION_SERVICE_ID. */
    public static final String PURCHASE_ORDER_CANCELLATION_SERVICE_ID = " ScmProcurementPurchaseOrderManagement.Cancellation.OrderRegistration";

    /** The Constant PURCHASE_ORDER_CANCELLATION_FRAMESET_PATH. */
    public static final String PURCHASE_ORDER_CANCELLATION_FRAMESET_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/ordercancellation/purchase-order-cancellation-framset";

    /** The Constant PURCHASE_ORDER_CORRECTION_FRAMESET_PATH. */
    public static final String PURCHASE_ORDER_INNER_CHANGE_FRAMESET_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinnerchange/purchase-order-inner-change-framset";

    /** The Constant PURCHASE_ORDER_CORRECTION_INPUT_PATH. */
    public static final String PURCHASE_ORDER_INNER_CHANGE_INPUT_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinnerchange/fragment/purchase-order-inner-change-input";

    /** The Constant PURCHASE_ORDER_CORRECTION_CONFIRM_PATH. */
    public static final String PURCHASE_ORDER_INNER_CHANGE_CONFIRM_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinnerchange/fragment/purchase-order-inner-change-confirm";

    /** The Constant PURCHASE_ORDER_CORRECTION_FINISH_PATH. */
    public static final String PURCHASE_ORDER_INNER_CHANGE_FINISH_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinnerchange/fragment/purchase-order-inner-change-finish";

    /** The Constant INTERNAL_CHANGE_TEXT_ID. */
    public static final String INTERNAL_CHANGE_TEXT_ID = "PROC.POMT.internalChangeOrder";

    /** The Constant INTERNAL_CANCEL_TEXT_ID. */
    public static final String INTERNAL_CANCEL_TEXT_ID = "PROC.POMT.internalCancelOrder";

    /** The Constant INTERNAL_CANCEL_TEXT_ID. */
    public static final String CHANGE_PURCHASE_ORDER_TEXT_ID = "PROC.POMT.changeOrder";

    /** The Constant INTERNAL_CANCEL_TEXT_ID. */
    public static final String CANCEL_PURCHASE_ORDER_TEXT_ID = "PROC.POMT.cancelOrder";

    /** The Constant CONFIRM_PARTIAL_CONFIG_KEY. */
    public static final String CONFIRM_PARTIAL_CONFIG_KEY = "confirmPartialConfigKey";

    /** The Constant FINISH_PARTIAL_CONFIG_KEY. */
    public static final String FINISH_PARTIAL_CONFIG_KEY = "finishPartialConfigKey";

    /** The Constant PURCHASE_ORDER_STATUS_TEXT */
    public static final String ORDERING_ON_REQUEST_TEXT_ID = "PROC.POMT.orderingOnRequest";

    /** The Constant PURCHASE_ORDER_STATUS_TEXT */
    public static final String MODIFICATION_ON_REQUEST_TEXT_ID = "PROC.POMT.modificationOnRequest";

    /** The Constant PURCHASE_ORDER_STATUS_TEXT */
    public static final String CANCEL_ON_REQUEST_TEXT_ID = "PROC.POMT.cancelOnRequest";

    /** The Constant PURCHASE_ORDER_STATUS_TEXT */
    public static final String WAITING_FOR_CANCEL_ORDER_SHEET_PRINTING_TEXT_ID = "PROC.POMT.waitingForCancelOrderSheetPrinting";

    /** The Constant CHANGE_PURCHASE_ORDER_CONFIRMATION */
    public static final String ORDER_ACCEPTED = "PC.POMT.orderAccepted";

    /** The Constant CHANGE_PURCHASE_ORDER_CONFIRMATION */
    public static final String ORDER_CONFORMATION_UNNECESSARY = "PC.POMT.orderConformationUnnecessary";

    /** The Constant PURCHASE_ORDER_STATUS_TEXT */
    public static final String CANCEL_ON_REQUEST = "CANCEL_ON_REQUEST";

    /** The Constant For NEW_APPLICATION */
    public static final String NEW_APPLICATION = "NEW_APPLICATION";

    /** The Constant For CHANGE_APPLICATION */
    public static final String CHANGE_APPLICATION = "CHANGE_APPLICATION";

    /** The Constant For CANCEL_APPLICATION */
    public static final String CANCEL_APPLICATION = "CANCEL_APPLICATION";

    /** The Constant For CANCEL_REQUESTING */
    public static final String CANCEL_REQUESTING = "CANCEL_REQUESTING";

    /** The Constant MODIFICATION_REMANDED. */
    public static final String MODIFICATION_REMANDED = "MODIFICATION_REMANDED";

    /** The Constant ON_MODIFICATION. */
    public static final String ON_MODIFICATION = "ON_MODIFICATION";

    /** The Constant CANCELLING_REMANDED. */
    public static final String CANCELLING_REMANDED = "CANCELLING_REMANDED";

    /** The Constant ON_CANCELLING. */
    public static final String ON_CANCELLING = "ON_CANCELLING";

    /** The Constant MODIFICATION_REJECTED. */
    public static final String MODIFICATION_REJECTED = "MODIFICATION_REJECTED";

    /** The Constant MODIFICATION_CANCELLED. */
    public static final String MODIFICATION_CANCELLED = "MODIFICATION_CANCELLED";

    /** The Constant CANCELLING_REJECTED. */
    public static final String CANCELLING_REJECTED = "CANCELLING_REJECTED";

    /** The Constant REMANDED. */
    public static final String CANCELLING_CANCELLED = "CANCELLING_CANCELLED";

    /** The Constant WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING. */
    public static final String WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING = "WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING";

    /** The Constant WAITING_FOR_CANCEL_SHEET_PRINT. */
    public static final String WAITING_FOR_CANCEL_SHEET_PRINT = "WAITING_FOR_CANCEL_SHEET_PRINT";

    /** The Constant WAITING_FOR_CANCEL_SHEET_PRINT. */
    public static final String CANCELLED = "CANCELLED";

    /** Internal Cancellation **/
    /** The Constant PURCHASE_ORDER_INTERNAL_CANCELLATION_INPUT_PATH. */
    public static final String PURCHASE_ORDER_INTERNAL_CANCELLATION_INPUT_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinternalcancellation/fragment/purchase-order-internal-cancellation-input";

    /** The Constant PURCHASE_ORDER_INTERNAL_CANCELLATION_CONFIRM_PATH. */
    public static final String PURCHASE_ORDER_INTERNAL_CANCELLATION_CONFIRM_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinternalcancellation/fragment/purchase-order-internal-cancellation-confirm";

    /** The Constant PURCHASE_ORDER_INTERNAL_CANCELLATION_FINISH_PATH. */
    public static final String PURCHASE_ORDER_INTERNAL_CANCELLATION_FINISH_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinternalcancellation/fragment/purchase-order-internal-cancellation-finish";

    /** The Constant PURCHASE_ORDER_INTERNAL_CANCELLATION_SERVICE_DEF_ID. */
    public static final String PURCHASE_ORDER_INTERNAL_CANCELLATION_SERVICE_DEF_ID = "ScmProcurementPurchaseOrderApplication.Cancel";

    /** The Constant PURCHASE_ORDER_INTERNAL_CANCELLATION_SERVICE_ID. */
    public static final String PURCHASE_ORDER_INTERNAL_CANCELLATION_SERVICE_ID = "ScmProcurementPurchaseOrderApplication.Cancel.InternalCancel";

    /** The Constant PURCHASE_ORDER_INTERNAL_CANCELLATION_FRAMESET_PATH. */
    public static final String PURCHASE_ORDER_INTERNAL_CANCELLATION_FRAMESET_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderinternalcancellation/purchase-order-internal-cancellation-framset";

    /** The Constant For LOCALE */
    public static final String LOCALE = "en";

    /** The Constant For SPACE */
    public static final String SPACE = " ";

    /** The Constant For ON_CANCELING */
    public static final String ON_CANCELING = "ON_CANCELING";

    /** The Constant For CANCEL_REQUEST */
    public static final String CANCEL_REQUEST = "CANCEL_REQUEST";

    /** The Constant For CANCEL_ON_TEMPORARY_SAVING */
    public static final String CANCEL_ON_TEMPORARY_SAVING = "CANCEL_ON_TEMPORARY_SAVING";

    /** The Constant YYYY_MM_DD */
    public static final String YYYY_MM_DD = "yyyy/MM/dd";

    /** The Constant ON_INTERNAL_CANCELING */
    public static final String ON_INTERNAL_CANCELING = "ON_INTERNAL_CANCELING";

    /** The Constant INTERNAL_CANCEL_ON_REQUEST */
    public static final String INTERNAL_CANCEL_ON_REQUEST = "INTERNAL_CANCEL_ON_REQUEST";

    /** The Constant PAGINGTOOL. */
    public static final String PAGINGTOOL = "pagingTool";

    /** The Constant COUNT_TRANSITION_NOT_AVAILABLE. */
    public static final int COUNT_TRANSITION_NOT_AVAILABLE = 1;

    /**
     * Fetch limit size for sima grid
     */
    public static final int FETCH_LIMIT = 15;
    /**
     * Fetch limit size for inbox list
     */
    public static final int INBOX_FETCH_LIMIT = 15;

    /** The Constant PURCHASE_ORDER_EXTERNAL_APPLICATION_FRAMESET_PATH */
    public static final String PURCHASE_ORDER_EXTERNAL_APPLICATION_FRAMESET_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderexternalapplication/purchase-order-external-application-framset";

    /** The Constant PURCHASE_ORDER_EXTERNAL_APPLICATION_INPUT_PATH */
    public static final String PURCHASE_ORDER_EXTERNAL_APPLICATION_INPUT_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderexternalapplication/fragment/purchase-order-external-application-input";

    /** The Constant PURCHASE_ORDER_EXTERNAL_APPLICATION_CONFIRM_PATH */
    public static final String PURCHASE_ORDER_EXTERNAL_APPLICATION_CONFIRM_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderexternalapplication/fragment/purchase-order-external-application-confirm";

    /** The Constant PURCHASE_ORDER_EXTERNAL_APPLICATION_FINISH_PATH */
    public static final String PURCHASE_ORDER_EXTERNAL_APPLICATION_FINISH_PATH = "templates/scm/procurement/ordermanagement/ordermanagement/inputframework/orderexternalapplication/fragment/purchase-order-external-application-finish";

    /** The Constant CHANGE_ORDER_REPORT */
    public static final String CHANGE_ORDER_REPORT = "changeOrderSheet";

    /** The Constant CHANGE_ORDER_CONFIRMATION_REPORT */
    public static final String CHANGE_ORDER_CONFIRMATION_REPORT = "changeOrderConfirmationSheet";

    /** The Constant CHANGE_OREDER_COPY */
    public static final String CHANGE_OREDER_COPY = "changeOrderSheetCopy";

    /** The Constant CANCEL_ORDER_REPORT */
    public static final String CANCEL_ORDER_REPORT = "cancelOrderSheet";

    /** The Constant CANCEL_OREDER_COPY */
    public static final String CANCEL_OREDER_COPY = "cancelOrderSheetCopy";

    /** The Constant WAITING_FOR_RECIEVING */
    public static final String WAITING_FOR_RECIEVING = "WAITING_FOR_RECIEVING";

    /** The Constant PRE_ORDER_ON_PROCUREMENT_REQUEST */
    public static final String PRE_ORDER_ON_PROCUREMENT_REQUEST = "PRE_ORDER_ON_PROCUREMENT_REQUEST";

    /** The Constant ORDERING_ON_QUOTATION */
    public static final String ORDERING_ON_QUOTATION = "ORDERING_ON_QUOTATION";

    /** The Constant NOT_PAYMENT_BY_RESULT */
    public static final String NOT_PAYMENT_BY_RESULT = "NOT_PAYMENT_BY_RESULT";

    /** The Constant NOT_PAYMENT_BY_RESULT_TEXT_ID */
    public static final String NOT_PAYMENT_BY_RESULT_TEXT_ID = StringUtils.EMPTY;

    /** The Constant MONTHLY */
    public static final String MONTHLY = "MONTHLY";

    /** The Constant MONTHLY_TEXT_ID */
    public static final String MONTHLY_TEXT_ID = StringUtils.EMPTY;

    /** The Constant ACCUMULATION */
    public static final String ACCUMULATION = "ACCUMULATION";

    /** The Constant ACCUMULATION_TEXT_ID */
    public static final String ACCUMULATION_TEXT_ID = StringUtils.EMPTY;

    /** The Constant REGULAR_ORDER */
    public static final String REGULAR_ORDER = "REGULAR_ORDER";

    /** The Constant REGULAR_ORDER_TEXT_ID */
    public static final String REGULAR_ORDER_TEXT_ID = StringUtils.EMPTY;

    /** The Constant PROVISIONAL_ORDER */
    public static final String PROVISIONAL_ORDER = "PROVISIONAL_ORDER";

    /** The Constant PROVISIONAL_ORDER_TEXT_ID */
    public static final String PROVISIONAL_ORDER_TEXT_ID = StringUtils.EMPTY;

    /** The Constant COMMON */
    public static final String COMMON = "COMMON";

    /** The Constant COMMON_TEXT_ID */
    public static final String COMMON_TEXT_ID = StringUtils.EMPTY;

    /** The Constant INDIVIDUAL */
    public static final String INDIVIDUAL = "INDIVIDUAL";

    /** The Constant INDIVIDUAL_TEXT_ID */
    public static final String INDIVIDUAL_TEXT_ID = StringUtils.EMPTY;

    /** The Constant PURCHASER_PAYS */
    public static final String PURCHASER_PAYS = "PURCHASER_PAYS";

    /** The Constant PURCHASER_PAYS_TEXT_ID */
    public static final String PURCHASER_PAYS_TEXT_ID = StringUtils.EMPTY;

    /** The Constant SUPPLIER_PAYS */
    public static final String SUPPLIER_PAYS = "SUPPLIER_PAYS";

    /** The Constant SUPPLIER_PAYS_TEXT_ID */
    public static final String SUPPLIER_PAYS_TEXT_ID = StringUtils.EMPTY;

    /** The Constant OWNERSHIP_TRANSFER_FINANCE_LEASE */
    public static final String OWNERSHIP_TRANSFER_FINANCE_LEASE = "OWNERSHIP_TRANSFER_FINANCE_LEASE";

    /** The Constant OWNERSHIP_TRANSFER_FINANCE_LEASE_TEXT_ID */
    public static final String OWNERSHIP_TRANSFER_FINANCE_LEASE_TEXT_ID = StringUtils.EMPTY;

    /** The Constant OPERATING_LEASE */
    public static final String OPERATING_LEASE = "OPERATING_LEASE";

    /** The Constant OPERATING_LEASE_TEXT_ID */
    public static final String OPERATING_LEASE_TEXT_ID = StringUtils.EMPTY;

    /** The Constant NON-OWNERSHIP_TRANSFER_FINANCE_LEASE */
    public static final String NONOWNERSHIP_TRANSFER_FINANCE_LEASE = "NON-OWNERSHIP_TRANSFER_FINANCE_LEASE";

    /** The Constant NON-OWNERSHIP_TRANSFER_FINANCE_LEASE_TEXT_ID */
    public static final String NONOWNERSHIP_TRANSFER_FINANCE_LEASE_TEXT_ID = StringUtils.EMPTY;

    /** The Constant EXCLUDING_TAX */
    public static final String EXCLUDING_TAX = "EXCLUDING_TAX";

    /** The Constant EXCLUDING_TAX_TEXT_ID */
    public static final String EXCLUDING_TAX_TEXT_ID = StringUtils.EMPTY;

    /** The Constant INCLUDING_TAX */
    public static final String INCLUDING_TAX = "INCLUDING_TAX";

    /** The Constant INCLUDING_TAX_TEXT_ID */
    public static final String INCLUDING_TAX_TEXT_ID = "PC.POMT.including_tax";

    /** The Constant GENERAL_TEXT_ID. */
    public static final String GENERAL_TEXT_ID = "PC.POMT.general";

    /** The Constant SERVICE_TEXT_ID. */
    public static final String SERVICE_TEXT_ID = "PC.POMT.service";

    /** The Constant LEASE_AND_RENTAL_TEXT_ID. */
    public static final String LEASE_AND_RENTAL_TEXT_ID = "PC.POMT.lease_and_rental";

    /** The Constant LICENSE_TEXT_ID. */
    public static final String LICENSE_TEXT_ID = "PC.POMT.license";

    /** The Constant RAW_MATERIALS_TEXT_ID. */
    public static final String RAW_MATERIALS_TEXT_ID = "PC.POMT.raw_materials";

    /** The Constant FROM_STOCK_TEXT_ID. */
    public static final String FROM_STOCK_TEXT_ID = "PC.POMT.from_stock";

    /** The Constant IS_INSPECTION_REQUIRED_TRUE */
    public static final String IS_INSPECTION_REQUIRED_TRUE = "PC.POMT.isInspectionRequired.True";

    /** The Constant IS_INSPECTION_REQUIRED_FALSE */
    public static final String IS_INSPECTION_REQUIRED_FALSE = "PC.POMT.isInspectionRequired.False";

    /** The Constant HAS_OWNERSHIP_TRANSFER_PROVISION_TRUE */
    public static final String HAS_OWNERSHIP_TRANSFER_PROVISION_TRUE = "PC.POMT.hasOwnershipTransferProvision.True";

    /** The Constant HAS_OWNERSHIP_TRANSFER_PROVISION_FALSE */
    public static final String HAS_OWNERSHIP_TRANSFER_PROVISION_FALSE = "PC.POMT.hasOwnershipTransferProvision.False";

    /** The Constant IS_SPECIAL_SPECIFICATION_PROPERTY_TRUE */
    public static final String IS_SPECIAL_SPECIFICATION_PROPERTY_TRUE = "PC.POMT.isSpecialSpecificationProperty.True";

    /** The Constant IS_SPECIAL_SPECIFICATION_PROPERTY_FALSE */
    public static final String IS_SPECIAL_SPECIFICATION_PROPERTY_FALSE = "PC.POMT.isSpecialSpecificationProperty.False";

    /** The Constant IS_LEASE_BACK_TRANSACTION_TRUE */
    public static final String IS_LEASE_BACK_TRANSACTION_TRUE = "PC.POMT.isLeasebackTransaction.True";

    /** The Constant IS_LEASE_BACK_TRANSACTION_FALSE */
    public static final String IS_LEASE_BACK_TRANSACTION_FALSE = "PC.POMT.isLeasebackTransaction.False";

    /** The Constant HAS_BARGAIN_PURCHASE_OPTION_TRUE */
    public static final String HAS_BARGAIN_PURCHASE_OPTION_TRUE = "PC.POMT.hasBargainPurchaseOption.True";

    /** The Constant HAS_BARGAIN_PURCHASE_OPTION_FALSE */
    public static final String HAS_BARGAIN_PURCHASE_OPTION_FALSE = "PC.POMT.hasBargainPurchaseOption.False";

    /** The Constant IS_PARTIAL_DELIVERY_AVAILABLE_TRUE */
    public static final String IS_PARTIAL_DELIVERY_AVAILABLE_TRUE = "PC.POMT.isPartialDeliveryAvailable.True";

    /** The Constant IS_PARTIAL_DELIVERY_AVAILABLE_TRUE */
    public static final String IS_PARTIAL_DELIVERY_AVAILABLE_FALSE = "PC.POMT.isPartialDeliveryAvailable.False";

    /** The Constant IS_SUBSTITUTE_AVAILABLE_TRUE */
    public static final String IS_SUBSTITUTE_AVAILABLE_TRUE = "PC.POMT.isSubstituteAvailable.True";

    /** The Constant IS_SUBSTITUTE_AVAILABLE_TRUE */
    public static final String IS_SUBSTITUTE_AVAILABLE_FALSE = "PC.POMT.isSubstituteAvailable.False";

    /** The Constant ACTUAL_MEASUREMENT_TRUE */
    public static final String ACTUAL_MEASUREMENT_TRUE = "PC.POMT.ActualMeasurement.True";

    /** The Constant ACTUAL_MEASUREMENT_FALSE */
    public static final String ACTUAL_MEASUREMENT_FALSE = "PC.POMT.ActualMeasurement.False";

    /** The Constant CAN_MODIFY_TRUE */
    public static final String CAN_MODIFY_TRUE = "PC.POMT.canModify.True";

    /** The Constant CAN_MODIFY_FALSE */
    public static final String CAN_MODIFY_FALSE = "PC.POMT.canModify.False";

    /** The Constant PRE_ORDER_ON_WAITING_FOR_MODIFICATION */
    public static final String PRE_ORDER_ON_WAITING_FOR_MODIFICATION = "PRE_ORDER_ON_WAITING_FOR_MODIFICATION";

    /** The Constant WAITING_FOR_DISPATCH_NOTIFICATION */
    public static final String WAITING_FOR_DISPATCH_NOTIFICATION = "WAITING_FOR_DISPATCH_NOTIFICATION";

    /** The Constant WAITING_FOR_INVOICE_ISSUING */
    public static final String WAITING_FOR_INVOICE_ISSUING = "WAITING_FOR_INVOICE_ISSUING";

    /** The Constant INVOICE_ISSUING_COMPLETED */
    public static final String INVOICE_ISSUING_COMPLETED = "INVOICE_ISSUING_COMPLETED";

    /** The Constant WAITING_FOR_MODIFICATION_CONFIRAMTION */
    public static final String WAITING_FOR_MODIFICATION_CONFIRAMTION = "WAITING_FOR_MODIFICATION_CONFIRAMTION";

    /** The Constant MODIFICATION_CONFIRMATION_DENIED */
    public static final String MODIFICATION_CONFIRMATION_DENIED = "MODIFICATION_CONFIRMATION_DENIED";

    /** The Constant MODIFICATION_ON_WITHDREW */
    public static final String MODIFICATION_ON_WITHDREW = "MODIFICATION_ON_WITHDREW";

    /** The Constant WAITING_FOR_PROVISIONAL_ORDER_COMMITION */
    public static final String WAITING_FOR_PROVISIONAL_ORDER_COMMITION = "WAITING_FOR_PROVISIONAL_ORDER_COMMITION";

    /** The Constant INTERNAL_CANCELED */
    public static final String INTERNAL_CANCELED = "INTERNAL_CANCELED";

    /** The Constant CANCELLATION_REMANDED */
    public static final String CANCELLATION_REMANDED = "CANCELLATION_REMANDED";

    /** The Constant CANCEL_ON_WITHDREW */
    public static final String CANCEL_ON_WITHDREW = "CANCEL_ON_WITHDREW";

    /** The Constant ORDERING_ON_WITHDREW */
    public static final String ORDERING_ON_WITHDREW = "ORDERING_ON_WITHDREW";

    /** The Constant CANCEL_REJECTED. */
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";

    /** The Constant ORDERING_REJECTED. */
    public static final String ORDERING_REJECTED = "ORDERING_REJECTED";

    /** The Constant CANCEL_FOR_MODIFICATION_CONFIRAMTION. */
    public static final String CANCEL_FOR_MODIFICATION_CONFIRAMTION = "CANCEL_FOR_MODIFICATION_CONFIRAMTION";

    /** The Constant RAISE_SYMBOL_TEXT_ID. */
    public static final String RAISE_SYMBOL_TEXT_ID = "PROC.POMT.riseSymbol";

    /** The Constant FALL_SYMBOL_TEXT_ID. */
    public static final String FALL_SYMBOL_TEXT_ID = "PROC.POMT.fallSymbol";

    /** The Constant RAISE_OR_FALL_SYMBOL. */
    public static final String RAISE_OR_FALL_SYMBOL = "riseOrFallSymbol";

    /** The Constant BEFORE_TOTAL_TAX_INCLUDED_AMOUNT. */
    public static final String BEFORE_TOTAL_TAX_INCLUDED_AMOUNT = "beforeTotalTaxIncludedAmount";

    /** The Constant BEFORE_TOTAL_COMSUMPTION_TAX_AMOUNT. */
    public static final String BEFORE_TOTAL_COMSUMPTION_TAX_AMOUNT = "beforeTotalComsumptionTaxAmount";

    /** The Constant TOTAL_TAX_INCLUDED_AMOUNT_DIFFERENCE. */
    public static final String TOTAL_TAX_INCLUDED_AMOUNT_DIFFERENCE = "totalTaxIncludedAmountDifference";

    /** The Constant TOTAL_COMSUMPTION_TAX_AMOUNT_DIFFERENCE. */
    public static final String TOTAL_COMSUMPTION_TAX_AMOUNT_DIFFERENCE = "totalComsumptionTaxAmountDifference";

    /** The Constant INNER_CHANGE_ORDER_TEXT_ID. */
    public static final String INNER_CHANGE_ORDER_TEXT_ID = "PC.POMT.inner.change.order";

    /** The Constant ON_INNER_MODIFICATION. */
    public static final String ON_INNER_MODIFICATION = "ON_INNER_MODIFICATION";

    /** The Constant ORDER_FOR_MODIFIED_TEXT_ID. */
    public static final String ORDER_FOR_MODIFIED_TEXT_ID = "PC.POMT.provisionalModified";

    /** The Constant ORDER_AT_CONFIRMATION_TEXT_ID. */
    public static final String ORDER_AT_CONFIRMATION_TEXT_ID = "PC.POMT.provisionalAtConfirmation";

    /** The Constant ORDER_AT_ATP_TEXT_ID. */
    public static final String ORDER_AT_ATP_TEXT_ID = "PC.POMT.provisionalAtDelivery";

    public enum PurchaseRequestSessionKey {
        NEW_APPLY("PURCHASEREQUEST_NEW_APPLY"),
        CORRECT_APPLY("PURCHASEREQUEST_CORRECT_APPLY"),
        CANCEL_APPLY("PURCHASEREQUEST_CANCEL_APPLY");

        /** The Constant sessionKeyPrefix */
        private final String sessionKeyPrefix;

        private PurchaseRequestSessionKey(String sessionKeyPrefix) {
            this.sessionKeyPrefix = sessionKeyPrefix;
        }

        /**
         * equals method used to validate the condition.
         *
         * @param sessionKeyPrefix
         * @return boolean
         */
        public boolean equals(String sessionKeyPrefix) {
            return this.sessionKeyPrefix.equals(sessionKeyPrefix);
        }

        /**
         * getSessionKeyPrefix method used to get the session key.
         *
         * @return String
         */
        public String getSessionKeyPrefix() {
            return sessionKeyPrefix;
        }
    }
}