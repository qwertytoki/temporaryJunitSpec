package com.worksap.company.hue.scm.biz.procurement.service.ordermanagement.ordermanagement.portal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.NumberFormat;
import com.worksap.company.framework.core.datetime.DateStyle;
import com.worksap.company.framework.core.datetime.DateTimeUtils;
import com.worksap.company.framework.core.datetime.HueDateTimeStyle;
import com.worksap.company.framework.core.datetime.HueDateTimeUtils;
import com.worksap.company.framework.core.i18n.MLString;
import com.worksap.company.framework.core.i18n.TimeZoneHolder;
import com.worksap.company.framework.elasticsearch.basic.autocomplete.AutocompleteEntity;
import com.worksap.company.framework.elasticsearch.basic.autocomplete.AutocompleteResult;
import com.worksap.company.framework.elasticsearch.basic.autocomplete.AutocompleteTypeSetting;
import com.worksap.company.framework.elasticsearch.basic.autocomplete.Autocompleter;
import com.worksap.company.framework.elasticsearch.basic.autocomplete.AutocompleterFactory;
import com.worksap.company.framework.elasticsearch.basic.docsearch.DocSearcherFactory;
import com.worksap.company.framework.elasticsearch.mapper.FullTextSearchResult;
import com.worksap.company.framework.elasticsearch.mapper.HitDocumentResponseMapper;
import com.worksap.company.framework.forneus.generator.handler.util.CommonDataAttributeType.CommonAllColorType;
import com.worksap.company.framework.forneus.generator.handler.util.CommonDataAttributeType.CommonDisplayType;
import com.worksap.company.framework.forneus.generator.handler.util.CommonDataAttributeType.CommonIconType;
import com.worksap.company.framework.forneus.generator.handler.util.CommonDataAttributeType.CommonMessageType;
import com.worksap.company.framework.forneus.generator.handler.util.LayoutAttributeType.DisplayType;
import com.worksap.company.framework.forneus.generator.handler.util.WapIconType;
import com.worksap.company.framework.forneus.generator.handler.vo.EmptyDataVo;
import com.worksap.company.framework.forneus.generator.handler.vo.SidemenuPersonalInfoVo;
import com.worksap.company.framework.forneus.generator.handler.vo.WapButtonVo;
import com.worksap.company.framework.forneus.generator.handler.vo.WapHeaderLabelVo;
import com.worksap.company.framework.forneus.generator.handler.vo.WapInboxIconRendererVo;
import com.worksap.company.framework.forneus.generator.handler.vo.WapInboxTagRendererVo;
import com.worksap.company.framework.forneus.generator.handler.vo.WapStatsLabelVo;
import com.worksap.company.framework.forneus.generator.handler.vo.WapTextLabelVo;
import com.worksap.company.framework.forneus.generator.handler.vo.valuekey.RowValueKey;
import com.worksap.company.framework.security.authority.AuthorityManager;
import com.worksap.company.framework.security.core.account.dao.AccountDao;
import com.worksap.company.framework.security.core.session.ServiceSessionCacheManager;
import com.worksap.company.framework.security.core.session.UserContext;
import com.worksap.company.framework.security.core.user.UserId;
import com.worksap.company.framework.service.ServiceId;
import com.worksap.company.framework.service.ServiceLinkId;
import com.worksap.company.framework.service.ServiceManager;
import com.worksap.company.framework.statementevaluator.core.logic.TokenTypeIdentifier;
import com.worksap.company.framework.textresource.TextId;
import com.worksap.company.framework.textresource.TextResourceManager;
import com.worksap.company.framework.type.Tuple2;
import com.worksap.company.hue.com.bizcore.ac.dao.DeptInChargeDao;
import com.worksap.company.hue.com.type.ac.DeptInCharge;
import com.worksap.company.hue.com.type.ac.PersonInCharge;
import com.worksap.company.hue.core.dto.ServiceLinkCfgDto;
import com.worksap.company.hue.scm.biz.com.context.ScmUserContext;
import com.worksap.company.hue.scm.biz.com.dao.personincharge.PersonInChargeDao;
import com.worksap.company.hue.scm.biz.procurement.entity.OrderManagementDashboardEntity;
import com.worksap.company.hue.scm.biz.procurement.entity.OrderManagementPortalEntity;
import com.worksap.company.hue.scm.biz.procurement.entity.ProcurementReceiptEntity;
import com.worksap.company.hue.scm.biz.procurement.vo.ordermanagement.ordermanagement.ResponsibleOrderInboxVo;
import com.worksap.company.hue.scm.bizcore.com.dao.CorporationDao;
import com.worksap.company.hue.scm.bizcore.procurement.basedao.PrPrintOrderSettingMstBaseDao;
import com.worksap.company.hue.scm.bizcore.procurement.constants.ProcurementServiceLinks;
import com.worksap.company.hue.scm.bizcore.procurement.constants.ordermanagement.OrderReportUsageConstants;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderAvailableToPromiseDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderConfirmationAnswerDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderDashboardOngoingDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderDetailDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderHeaderDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderPlanDetailDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderPlanHeaderDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.OrderSearchDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.PurchaseDashboardAlertDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.ResponsibleOrderBySupDao;
import com.worksap.company.hue.scm.bizcore.procurement.dao.ordermanagement.ResponsibleOrderDao;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderAvailableToPromiseEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderBySupEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderConfirmationAnswerEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderDashboardOngoingEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderDetailEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderHeaderEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderManagementEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderPlanDetailEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.OrderPlanHeaderEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.PrintOrderSettingMstEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.PurchaseDashboardAlertEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.ResponsibleOrderBySupEntity;
import com.worksap.company.hue.scm.bizcore.procurement.entity.ResponsibleOrderEntity;
import com.worksap.company.hue.scm.bizcore.procurement.enumerations.ordermanagement.OrderDashboardOngoingDtoElementType;
import com.worksap.company.hue.scm.bizcore.procurement.enumerations.ordermanagement.OrderDashboardOngoingDtoRowType;
import com.worksap.company.hue.scm.bizcore.procurement.enumerations.ordermanagement.OrderReportType;
import com.worksap.company.hue.scm.bizcore.procurement.enumerations.ordermanagement.OrderStatus;
import com.worksap.company.hue.scm.bizcore.procurement.service.facade.AcceptanceFacadeService;
import com.worksap.company.hue.scm.bizcore.procurement.service.order.common.OrderConfirmationService;
import com.worksap.company.hue.scm.bizcore.procurement.service.order.common.OrderStatusControlService;
import com.worksap.company.hue.scm.bizcore.procurement.service.order.common.report.OrderReportService;
import com.worksap.company.hue.scm.bizcore.procurement.service.order.common.report.OrderReportUsageDecisionService;
import com.worksap.company.hue.scm.bizcore.procurement.service.order.common.report.ReportSettingEntities;
import com.worksap.company.hue.scm.bizcore.procurement.service.ordermanagement.OrderManagementOuterFacadeEntityConverterService;
import com.worksap.company.hue.scm.bizcore.procurement.service.ordermanagement.OrderSearchRegisterService;
import com.worksap.company.hue.scm.bizcore.procurement.service.ordermanagement.constant.OrderManagementConstant;
import com.worksap.company.hue.scm.bizcore.procurement.util.UUIDValidator;
import com.worksap.company.hue.scm.type.procurement.AvailableToPromiseBean;
import com.worksap.company.hue.scm.type.procurement.ContractClassification;
import com.worksap.company.hue.scm.type.procurement.ordermanagement.enums.OrderManagementDashboardEnum;
import com.worksap.company.hue.scm.type.procurement.ordermanagement.enums.PurchaseProcessTypeEnum;
import com.worksap.company.hue.scm.type.procurement.ordermanagement.enums.UserSegmentEnum;

/**
 * OrderManagementServiceImpl Instantiates a new order management service impl.
 *
 * @author DineshKumar
 * @since HUE 17.05
 *
 * @param orderDashboardOnGoingDao
 *
 * @param responsibleOrderDao
 *
 * @param purchaseDashboardAlertDao
 *
 * @param orderHeaderDao
 *
 * @param responsibleOrderBySupDao
 *
 * @param scmUserContext
 *
 * @param context
 *
 * @param textResourceManager
 *
 * @param authorityManager
 *
 * @param serviceManager
 *
 * @param orderPlanHeaderDao
 *
 * @param session
 *
 * @param orderConfirmationAnswerDao
 *
 * @param orderAvailableToPromiseDao
 *
 * @param orderDetailDao
 *
 * @param corporationDao
 *
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderManagementServiceImpl implements OrderManagementService {

    /** The order dashboard on going dao. */
    private final OrderDashboardOngoingDao orderDashboardOnGoingDao;

    /** The responsible order dao. */
    private final ResponsibleOrderDao responsibleOrderDao;

    /** The purchase dashboard alert dao. */
    private final PurchaseDashboardAlertDao purchaseDashboardAlertDao;

    /** The order header dao. */
    private final OrderHeaderDao orderHeaderDao;

    /** The responsible order by sup dao. */
    private final ResponsibleOrderBySupDao responsibleOrderBySupDao;

    /** The person in charge dao. */
    private final PersonInChargeDao personInChargeDao;

    /** The scm user context. */
    private final ScmUserContext scmUserContext;
    /** The user context. */
    private final UserContext context;

    /** The text resource manager. */
    private final TextResourceManager textResourceManager;

    /** The authority manager. */

    private final AuthorityManager authorityManager;

    /** The service manager. */

    private final ServiceManager serviceManager;

    /** The order plan header dao. */
    private final OrderPlanHeaderDao orderPlanHeaderDao;

    /** The session. */
    private final ServiceSessionCacheManager session;

    /** The orderConfirmationAnswerDao. */
    private final OrderConfirmationAnswerDao orderConfirmationAnswerDao;

    /** The orderAvailableToPromiseDao. */
    private final OrderAvailableToPromiseDao orderAvailableToPromiseDao;

    /** The OrderDetailDao. */
    private final OrderDetailDao orderDetailDao;

    /** The corporation dao. */
    private final CorporationDao corporationDao;

    /** The factory. */
    private final AutocompleterFactory factory;

    /** The AccountDao. */
    private final AccountDao accountDao;

    /** The OrderSearchDao. */
    private final OrderSearchDao orderSearchDao;

    /** The PrPrintOrderSettingMstBaseDao. */
    private final PrPrintOrderSettingMstBaseDao prPrintOrderSettingMstBaseDao;

    @NonNull
    private final OrderReportService orderReportService;

    @NonNull
    private final OrderManagementOuterFacadeEntityConverterService orderManagementOuterFacadeEntityConverterService;

    @NonNull
    private final AcceptanceFacadeService acceptanceFacadeService;

    private final OrderSearchRegisterService orderSearchRegisterService;

    private final DocSearcherFactory docSearchFactory;

    /** The OrderStatusControlService. */
    private final OrderStatusControlService orderStatusControlService;

    @NonNull
    private final OrderReportUsageDecisionService reportUsageDecisionService;

    @NonNull
    private final OrderConfirmationService orderConfirmationService;

    @NonNull
    private final com.worksap.company.hue.com.bizcore.ac.dao.PersonInChargeDao comAcPersonInChargeDao;

    @NonNull
    private final DeptInChargeDao deptInChargeDao;

    @NonNull
    private final OrderPlanDetailDao orderPlanDetailDao;

    /** The Constant PROVISIONAL_COUNT_STATUS. */
    public static final String PROVISIONAL_COUNT_STATUS = "PC.POMT.provisionalPensingStatus";

    /**
     * businessDataMap.
     *
     * @return businessDataMap
     */
    @Override
    public Map<String, Object> doIndex() {

        Map<String, Object> businessDataMap = new HashMap<>();
        String userId = scmUserContext.getUserId().toString();
        long corpId = scmUserContext.getActiveCorpId();
        UUID deptInChargeId = scmUserContext.getActiveDeptInChargeId();
        UUID personInChargeId = scmUserContext.getPersonInChargeId();
        RowValueKey.Builder rowData = new RowValueKey.Builder();
        businessDataMap.put("showData", rowData.display(DisplayType.NONE).build());
        List<OrderManagementPortalEntity> proceedingsList = loadProceedingsList(corpId, deptInChargeId,
                personInChargeId);
        List<OrderManagementDashboardEntity> confirmedList = loadPortalConfirmList(userId, corpId);
        if (proceedingsList.isEmpty()) {
            EmptyDataVo emptyDataVo = new EmptyDataVo.Builder().display(DisplayType.DISPLAYED).build();
            WapHeaderLabelVo wapHeaderLabelVo = new WapHeaderLabelVo.Builder().display(CommonDisplayType.NONE).build();
            businessDataMap.put("messageEmptyData", emptyDataVo);
            businessDataMap.put("showData", rowData.display(DisplayType.DISPLAYED).build());
            businessDataMap.put("toConfirmedHeaderLabel", wapHeaderLabelVo);
            businessDataMap.put("processHeaderLabel", wapHeaderLabelVo);

        } else if (confirmedList.isEmpty()) {
            WapHeaderLabelVo wapHeaderLabelVo = new WapHeaderLabelVo.Builder().display(CommonDisplayType.NONE).build();
            businessDataMap.put("toConfirmedHeaderLabel", wapHeaderLabelVo);
        }
        businessDataMap.put("orderPortalInboxData", proceedingsList);
        businessDataMap.put("orderDashboardInboxData", confirmedList);
        String organizationName = scmUserContext.getUser().getProfiles().getMainProfile().getOrganizationName() != null
                ? scmUserContext.getUser().getProfiles().getMainProfile().getOrganizationName().get() : "";
        businessDataMap.put("sidemenuPersonalInfo", new SidemenuPersonalInfoVo(scmUserContext.getUser()
                .getPicturePath(),
                scmUserContext
                        .getUser().getName(),
                organizationName));

        return businessDataMap;
    };

    /**
     * Generate each filter's portal message and return
     *
     * @param userId
     * @param corpId
     * @param deptInChargeId
     * @param personInChargeId
     * @return
     */
    private List<OrderManagementPortalEntity> loadProceedingsList(Long corpId, UUID deptInChargeId,
            UUID personInChargeId) {
        List<ResponsibleOrderEntity> orderManagementDetailEntityList;
        if (Objects.nonNull(deptInChargeId)) {
            orderManagementDetailEntityList = responsibleOrderDao.getAllByDeptInCharge(deptInChargeId, corpId,
                    UserSegmentEnum.GROUP);
            orderManagementDetailEntityList.addAll(responsibleOrderDao.getFilteredRecords(null,
                    deptInChargeId, corpId,
                    UserSegmentEnum.GROUP.getValue(), OrderManagementConstant.PROCUREMENT_REQUEST_TYPE));
        } else if (Objects.nonNull(personInChargeId)) {
            orderManagementDetailEntityList = responsibleOrderDao.getAllByPersonInCharge(personInChargeId, corpId,
                    UserSegmentEnum.GROUP);
            orderManagementDetailEntityList.addAll(responsibleOrderDao.getFilteredRecords(personInChargeId,
                    null, corpId,
                    UserSegmentEnum.GROUP.getValue(), OrderManagementConstant.PROCUREMENT_REQUEST_TYPE));
        } else {
            return Collections.emptyList();
        }
        int countProvisionByOrderStatus = loadProvisionalData(deptInChargeId, corpId,
                UserSegmentEnum.GROUP.getValue(), personInChargeId).size();

        Map<String, List<ResponsibleOrderEntity>> listByRowTypeMap = orderManagementDetailEntityList
                .stream()
                .filter(filter -> StringUtils.isNotEmpty(filter.getType()))
                .collect(Collectors.groupingBy(ResponsibleOrderEntity::getType,
                        Collectors.toList()));

        Set<String> rowTypes = orderManagementDetailEntityList
                .stream()
                .map(ResponsibleOrderEntity::getType)
                .collect(Collectors.toSet());

        List<OrderManagementPortalEntity> orderManagementInprogressEntityList = new ArrayList<>();
        if (rowTypes.contains(OrderManagementConstant.PROCUREMENT_REQUEST_TYPE)) {
            orderManagementInprogressEntityList.add(buildProcurementMessage(getCountByOrderStatus(listByRowTypeMap,
                    OrderManagementConstant.PROCUREMENT_REQUEST_TYPE)));
        }
        if (rowTypes.contains(OrderManagementConstant.ON_ORDER)) {
            orderManagementInprogressEntityList.add(buildApplyOrderMessage(getCountByOrderStatus(listByRowTypeMap,
                    OrderManagementConstant.ON_ORDER)));
        }
        if (rowTypes.contains(OrderManagementConstant.WAITING_FOR_ORDERSHEET_PRINTING)) {
            orderManagementInprogressEntityList.add(buildWaitIssuanceMessage(getCountByOrderStatus(listByRowTypeMap,
                    OrderManagementConstant.WAITING_FOR_ORDERSHEET_PRINTING)));
        }
        if (rowTypes.contains(OrderManagementConstant.WAITING_FOR_ORDER_CONFIRMATION)) {
            orderManagementInprogressEntityList.add(buildPendingOrderMessage(getCountByOrderStatus(listByRowTypeMap,
                    OrderManagementConstant.WAITING_FOR_ORDER_CONFIRMATION), listByRowTypeMap));
        }
        if (rowTypes.contains(OrderManagementConstant.WAITING_FOR_ATP_ANSWER_STATUS_TEXT_ID)) {
            orderManagementInprogressEntityList
                    .add(buildWaitingForDeliveryMessage(getCountByOrderStatus(listByRowTypeMap,
                            OrderManagementConstant.WAITING_FOR_ATP_ANSWER_STATUS_TEXT_ID),
                            listByRowTypeMap));
        }
        orderManagementInprogressEntityList.add(buildPendingProvisionOrderMessage(countProvisionByOrderStatus));
        return orderManagementInprogressEntityList;
    }

    /**
     * getCountByOrderStatus is used to get count with respect of status.
     *
     * @param rowTypeOrderedMap
     * @param rowType
     *
     * @return Map<String, Integer>
     */
    private Map<String, Integer> getCountByOrderStatus(Map<String, List<ResponsibleOrderEntity>> rowTypeOrderedMap,
            String rowType) {
        if (OrderManagementConstant.WAITING_FOR_ORDERSHEET_PRINTING.equals(rowType)) {
            Map<String, Integer> orderSheetCountMap = new HashMap<>();
            orderSheetCountMap.put(rowType, rowTypeOrderedMap.get(rowType).size());
            return orderSheetCountMap;
        }
        return rowTypeOrderedMap.get(rowType)
                .stream()
                .map(ResponsibleOrderEntity::getOrderStatus)
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, s -> 1, Integer::sum)));
    }

    /**
     * Create dashboard messages of Procurement Request.
     *
     * @param groupMap
     *            Key is orderStatus, Value is amount of orders of each Key status.
     * @return OrderManagementPortalEntity
     */
    private OrderManagementPortalEntity buildProcurementMessage(Map<String, Integer> groupMap) {
        WapInboxIconRendererVo cartIcon = new WapInboxIconRendererVo.Builder().roundType(true)
                .colorType(CommonAllColorType.PRIMARY)
                .iconType(CommonIconType.CART).build();
        int orderRequestCount = groupMap.getOrDefault(
                OrderStatus.PRE_ORDER_ON_WAITING_FOR_ACCEPTANCE.name(), 0);
        int orderModificationRequestCount = groupMap.getOrDefault(
                OrderStatus.PRE_ORDER_ON_WAITING_FOR_MODIFICATION.name(), 0);

        String messageString;
        if (orderRequestCount > OrderManagementConstant.NUMERIC_ONE) {
            messageString = OrderManagementConstant.SCM_PR_ORDER_PROCUREMENT_MESSAGE_INFO;
        } else {
            messageString = OrderManagementConstant.SCM_PR_ORDER_PROCUREMENT_SINGLEMESSAGE_INFO;
        }
        String procurementRequest = textResourceManager.getTextWithParam(
                TextId.of(messageString),
                orderRequestCount,
                orderModificationRequestCount);
        return new OrderManagementPortalEntity(cartIcon,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.PROCUREMENT_REQUEST)),
                procurementRequest,
                OrderManagementConstant.PROCUREMENT_REQUEST_TYPE, OrderManagementConstant.NUMERIC_ZERO);
    }

    /**
     * Create dashboard messages of Applying for Order.
     *
     * @param groupMap
     *            Key is orderStatus, Value is amount of orders of each Key status.
     * @return OrderManagementPortalEntity
     */
    private OrderManagementPortalEntity buildApplyOrderMessage(Map<String, Integer> groupMap) {
        WapInboxIconRendererVo fileIcon = new WapInboxIconRendererVo.Builder().roundType(true)
                .colorType(CommonAllColorType.PRIMARY)
                .iconType(CommonIconType.FILE).build();
        int orderRemandedCount = 0;
        int orderingRemandedCount = groupMap.getOrDefault(OrderStatus.ORDERING_REMANDED.name(), 0);
        int cancelRemandedCount = groupMap.getOrDefault(OrderStatus.CANCELLATION_REMANDED.name(), 0);
        int modificationRemandedCount = groupMap.getOrDefault(OrderStatus.MODIFICATION_REMANDED.name(), 0);
        orderRemandedCount = orderingRemandedCount + cancelRemandedCount + modificationRemandedCount;
        int orderTemporarySavingCount = groupMap.getOrDefault(
                OrderStatus.ORDERING_ON_TEMPORARY_SAVING.name(), 0);

        String messageString;
        if (orderRemandedCount > OrderManagementConstant.NUMERIC_ONE) {
            messageString = OrderManagementConstant.SCM_PR_ORDER_APPLYING_MESSAGE_INFO;
        } else {
            messageString = OrderManagementConstant.SCM_PR_ORDER_APPLYING_SINGLEMESSAGE_INFO;
        }
        String applyingForOrder = textResourceManager.getTextWithParam(
                TextId.of(messageString), orderRemandedCount, orderTemporarySavingCount);
        return new OrderManagementPortalEntity(fileIcon,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.APPLYING_FOR_ORDER)),
                applyingForOrder,
                OrderManagementConstant.APPLYING_ORDER_NOT_SHOW, OrderManagementConstant.NUMERIC_ZERO);
    }

    /**
     * Create dashboard messages of Wait for Issuance of Order
     *
     * @param groupMap
     *            Key is orderStatus, Value is amount of orders of each Key status.
     * @return OrderManagementPortalEntity
     */
    private OrderManagementPortalEntity buildWaitIssuanceMessage(Map<String, Integer> groupMap) {
        WapInboxIconRendererVo printIcon = new WapInboxIconRendererVo.Builder().roundType(true)
                .colorType(CommonAllColorType.PRIMARY)
                .iconType(CommonIconType.PRINT).build();
        int orderWaitingForOrderSheetPrintCount = groupMap.getOrDefault(
                OrderStatus.WAITING_FOR_ORDER_SHEET_PRINTING.name(), 0);
        String messageString;
        if (orderWaitingForOrderSheetPrintCount > OrderManagementConstant.NUMERIC_ONE) {
            messageString = OrderManagementConstant.SCM_PR_ORDER_WAITISSUANCE_MESSAGE_INFO;
        } else {
            messageString = OrderManagementConstant.SCM_PR_ORDER_WAITISSUANCE_SINGLEMESSAGE_INFO;
        }
        String waitForIssuanceOfOrder = textResourceManager.getTextWithParam(
                TextId.of(messageString),
                orderWaitingForOrderSheetPrintCount);
        return new OrderManagementPortalEntity(printIcon,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.WAIT_FOR_ISSUANCE_OF_ORDER)),
                waitForIssuanceOfOrder, OrderManagementConstant.ISSUANCE_OF_ORDER_NOT_SHOW,
                OrderManagementConstant.NUMERIC_ZERO);

    }

    /**
     * Create dashboard messages of Pending Orders
     *
     * @param groupMap
     *            Key is orderStatus, Value is amount of orders of each Key status
     * @param listByRowTypeMap
     *            Key is RowType which is OrderEntity's type, Value is OrderEntity whose type is same as RowType
     * @return OrderManagementPortalEntity
     */
    private OrderManagementPortalEntity buildPendingOrderMessage(Map<String, Integer> groupMap,
            Map<String, List<ResponsibleOrderEntity>> listByRowTypeMap) {
        WapInboxIconRendererVo taskIcon = new WapInboxIconRendererVo.Builder()
                .roundType(true).colorType(CommonAllColorType.PRIMARY).iconType(CommonIconType.TASK_CHECK)
                .build();

        int orderConfirmationDelayedCountCount = getDelayResponseCountforPendingOrderMessage(listByRowTypeMap);

        int orderConfirmationInputCount = groupMap.getOrDefault(
                OrderStatus.WAITING_FOR_CONFIRMATION.name(), 0);

        String messageString;
        if (orderConfirmationDelayedCountCount > OrderManagementConstant.NUMERIC_ONE) {
            messageString = OrderManagementConstant.SCM_PR_ORDER_PENDING_LISTMESSAGE_INFO;
        } else {
            messageString = OrderManagementConstant.SCM_PR_ORDER_PENDING_MESSAGE_INFO;
        }
        String pendingOrdersPending = textResourceManager.getTextWithParam(
                TextId.of(messageString),
                orderConfirmationDelayedCountCount, orderConfirmationInputCount);
        return new OrderManagementPortalEntity(taskIcon,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.PENDING_ORDER_PENDING)),
                pendingOrdersPending, OrderManagementConstant.PENDING_ORDER_NOT_SHOW,
                OrderManagementConstant.NUMERIC_ZERO);
    }

    /**
     * getDelayResponseCountforPendingOrderMessage return the count of orders which are expired desiredDeliveryDate.
     *
     * @param listByRowTypeMap
     *
     * @return int the count of orders which are expired desiredDeliveryDate.
     */
    private int getDelayResponseCountforPendingOrderMessage(
            Map<String, List<ResponsibleOrderEntity>> listByRowTypeMap) {
        List<ResponsibleOrderEntity> responsibleOrderEntityList = listByRowTypeMap
                .get(OrderManagementConstant.WAITING_FOR_ORDER_CONFIRMATION);
        List<ResponsibleOrderEntity> filteredList = responsibleOrderEntityList
                .stream()
                .filter(filter -> {
                    if (Objects.nonNull(filter.getDesiredDeliveryDateTime())) {
                        ZonedDateTime desiredDeliveryDate = ZonedDateTime.ofInstant(filter.getDesiredDeliveryDateTime()
                                .toInstant(),
                                scmUserContext.getZoneId());
                        ZonedDateTime currentDate = ZonedDateTime.ofInstant(ZonedDateTime.now()
                                .toInstant(),
                                scmUserContext.getZoneId());
                        return !currentDate.equals(desiredDeliveryDate) && currentDate.isAfter(desiredDeliveryDate);
                    } else {
                        return false;
                    }
                }).collect(Collectors.toList());
        return filteredList.size();
    }

    /**
     * buildPendingProvisionOrderMessage is used to set provisional record details in main page.
     *
     * @param groupMap
     * @return OrderManagementPortalEntity
     */
    private OrderManagementPortalEntity buildPendingProvisionOrderMessage(int orderProvisionalInputCount) {
        WapInboxIconRendererVo taskIcon = new WapInboxIconRendererVo.Builder()
                .roundType(true).colorType(CommonAllColorType.PRIMARY).iconType(CommonIconType.FILE)
                .build();
        String messageString = OrderManagementConstant.SCM_PR_ORDER_PROVISIONAL_MESSAGE_INFO;
        String pendingOrdersPending = textResourceManager.getTextWithParam(
                TextId.of(messageString),
                orderProvisionalInputCount);
        return new OrderManagementPortalEntity(taskIcon,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.PROVISIONAL_ORDER_PENDING)),
                pendingOrdersPending, OrderManagementConstant.PENDING_PROVISIONAL_ORDER,
                OrderManagementConstant.NUMERIC_ZERO);
    }

    /**
     * Create dashboard messages of Waiting For Delivery
     *
     * @param groupMap
     *            Key is orderStatus, Value is amount of orders of each Key status
     * @param listByRowTypeMap
     *            Key is RowType which is OrderEntity's type, Value is OrderEntity whose type is same as RowType
     * @return OrderManagementPortalEntity
     */
    private OrderManagementPortalEntity buildWaitingForDeliveryMessage(Map<String, Integer> groupMap,
            Map<String, List<ResponsibleOrderEntity>> listByRowTypeMap) {
        WapInboxIconRendererVo calendarIcon = new WapInboxIconRendererVo.Builder().roundType(true)
                .colorType(CommonAllColorType.PRIMARY)
                .iconType(CommonIconType.CALENDAR).build();

        List<ResponsibleOrderEntity> responsibleOrderEntity = new ArrayList<>();
        if (listByRowTypeMap.containsKey(OrderManagementConstant.WAITING_FOR_RECEIVING)) {
            responsibleOrderEntity = listByRowTypeMap
                    .get(OrderManagementConstant.WAITING_FOR_RECEIVING);
        }

        if (listByRowTypeMap.containsKey(OrderManagementConstant.WAITING_FOR_ORDER_MATCHING)) {
            responsibleOrderEntity.addAll(listByRowTypeMap
                    .get(OrderManagementConstant.WAITING_FOR_ORDER_MATCHING));
        }

        int waitingForAnswerDelayedCount = Integer
                .parseInt(getDelayedCountForWaitingForDeliveryMessage(responsibleOrderEntity));

        int waitingForAnswerInputCount = groupMap.getOrDefault(
                OrderStatus.WAITING_FOR_ATP_ANSWER.name(), 0);

        String messageString;
        if (waitingForAnswerDelayedCount > OrderManagementConstant.NUMERIC_ONE) {
            messageString = OrderManagementConstant.SCM_PR_ORDER_WAITING_MESSAGE_INFO;
        } else {
            messageString = OrderManagementConstant.SCM_PR_ORDER_WAITINGORDER_SINGLEMESSAGE_INFO;
        }
        String waitingForDelivery = textResourceManager.getTextWithParam(
                TextId.of(messageString),
                waitingForAnswerDelayedCount, waitingForAnswerInputCount);
        return new OrderManagementPortalEntity(calendarIcon,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.WAIT_FOR_DELIVERY)),
                waitingForDelivery,
                OrderManagementConstant.WAITING_FOR_DELIVERYNOT_SHOW, OrderManagementConstant.NUMERIC_ZERO);
    }

    /**
     * Return the number of delayed orders which compare with Available To Promise data and order data
     * atpEntity.getAtpList() is usually only 1 column.
     *
     * @param responsibleOrderEntityList
     *            Order list filtered by "status = WAITING_FOR_ATP_ANSWER"
     */
    private String
            getDelayedCountForWaitingForDeliveryMessage(List<ResponsibleOrderEntity> responsibleOrderEntityList) {
        AtomicInteger index = new AtomicInteger();
        // FIXME Don't use getAll. It should be filtered by responsibleOrderEntityList.orderIds.
        List<OrderAvailableToPromiseEntity> atpRecordsList = orderAvailableToPromiseDao.getAllAtpRecords();
        responsibleOrderEntityList.stream().forEach(
                entity -> {
                    if (Objects.nonNull(entity.getDesiredDeliveryDateTime())) {
                        List<OrderAvailableToPromiseEntity> atpEntityList = atpRecordsList
                                .stream()
                                .filter(predicate -> predicate.getOrderId().equals(entity.getOrderId()))
                                .collect(Collectors.toList());

                        for (OrderAvailableToPromiseEntity atpEntity : atpEntityList) {
                            if (Objects.nonNull(atpEntity.getAtpId())) {
                                List<AvailableToPromiseBean> delayList = atpEntity.getAtpList()
                                        .stream()
                                        .filter(detail -> checkAnsweredDate(detail, entity))
                                        .collect(Collectors.toList());
                                if (delayList.size() > 0) {
                                    index.getAndIncrement();
                                    break;
                                }
                            }
                        }
                    }
                });

        return index.toString();
    }

    /**
     * Return true if atpBean.answeredDate pass ResponsibleOrderEntity.desiredDeliveryTime
     *
     * @param responsibleOrderEntity
     * @param AvailableToPromiseBean
     *
     * @return the Boolean
     */
    private Boolean checkAnsweredDate(AvailableToPromiseBean availableToPromiseBean,
            ResponsibleOrderEntity responsibleOrderEntity) {
        Boolean isDelayed = false;
        if (Objects.nonNull(availableToPromiseBean.getAnsweredDate())) {
            ZonedDateTime answeredDate = ZonedDateTime.ofInstant(availableToPromiseBean.getAnsweredDate().toInstant(),
                    scmUserContext.getZoneId());
            isDelayed = answeredDate
                    .isAfter(responsibleOrderEntity.getDesiredDeliveryDateTime())
                    && !answeredDate
                            .equals(responsibleOrderEntity.getDesiredDeliveryDateTime());
        }
        return isDelayed;
    }

    /**
     * Return List<ResponsibleOrderInboxVo> whose order status is equal to status(2nd parameter).
     *
     * @param responsibleOrderEntityList
     * @param Status 
     *          order status
     */
    private List<ResponsibleOrderInboxVo> checkStatus(List<ResponsibleOrderInboxVo> responsibleOrderEntityList,
            String status) {

        List<ResponsibleOrderInboxVo> registrationList = responsibleOrderEntityList.stream()
                .filter(predicate -> predicate.getOrderStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());

        return registrationList;
    }

    /**
     * loadPortalConfirmList.
     *
     * @param userId
     *            the user id
     * @return orderManagementDashboardEntityList
     */

    @Override
    public List<OrderManagementDashboardEntity> loadPortalConfirmList(String userId, long corpId) {

        List<OrderManagementDashboardEntity> orderManagementDashboardEntityList = new ArrayList<>();
        List<PurchaseDashboardAlertEntity> purchaseDashboardAlertEntityList = purchaseDashboardAlertDao
                .getAllDetailsForSpecificAlert(userId, corpId, "ORDER", "ORDER_REMANDED");
        Map<String, List<PurchaseDashboardAlertEntity>> aleartsByCause = purchaseDashboardAlertEntityList
                .stream()
                .collect(Collectors.groupingBy(PurchaseDashboardAlertEntity::getCause));

        aleartsByCause.entrySet()
                .stream()
                .forEach(
                        entry -> {
                            OrderManagementDashboardEnum cause = OrderManagementDashboardEnum.valueOf(entry
                                    .getKey());
                            List<PurchaseDashboardAlertEntity> alearts = entry.getValue();
                            String message = textResourceManager.getTextWithParam(TextId.of(cause.getValueOne()),
                                    alearts.size());
                            String priority = alearts.stream().findAny()
                                    .map(PurchaseDashboardAlertEntity::getPriority).orElse(null);
                            orderManagementDashboardEntityList.add(new OrderManagementDashboardEntity(
                                    generateInboxIconRendererVo(priority), message, cause.name()));
                        });

        return orderManagementDashboardEntityList;
    }

    /**
     * Return Warning Icon if priority is "WARNING". else return Danger Icon.
     *
     * @param String priority
     */
    private WapInboxIconRendererVo generateInboxIconRendererVo(String priority) {
        CommonAllColorType type = StringUtils.equals(priority, OrderManagementConstant.WARNING)
                ? CommonAllColorType.WARNING
                : CommonAllColorType.DANGER;
        return new WapInboxIconRendererVo.Builder()
                .roundType(true)
                .colorType(type)
                .iconType(CommonIconType.WARNING).build();
    }

    /**
     * setSwitchToVendorData.
     *
     * @param responsibleOrderBySupEntityList
     *            the responsible order by sup entity list
     * @return the map
     */
    private Map<String, Object>
            setSwitchToVendorData(List<ResponsibleOrderBySupEntity> responsibleOrderBySupEntityList) {

        Map<String, Object> switchToVendorReturnMap = new HashMap<>();

        responsibleOrderBySupEntityList = responsibleOrderBySupEntityList
                .stream()
                .filter(entity -> Objects.nonNull(entity.getSupplier())
                        && StringUtils.isNotEmpty(entity.getSupplier().toString()))
                .collect(Collectors.toList());
        Map<String, List<String>> supplierNameMap = responsibleOrderBySupEntityList
                .stream()
                .map(mapper -> mapper.getSupplierName().get())
                .collect(Collectors.groupingBy(classifier -> classifier, Collectors.toList()));

        List<String> supplierList = responsibleOrderBySupEntityList
                .stream()
                .map(mapper -> mapper.getSupplier().toString())
                .distinct()
                .collect(Collectors.toList());

        List<OrderBySupEntity> printList = responsibleOrderBySupEntityList
                .stream()
                .filter(entity -> Objects.nonNull(entity.getSupplier())
                        && StringUtils.isNotEmpty(entity.getSupplier().toString())
                        && supplierList.contains(entity.getSupplier().toString()))
                .map(mapper -> {

                    OrderBySupEntity orderBySupEntity = new OrderBySupEntity();
                    if (Objects.nonNull(mapper.getSupplierName())) {
                        orderBySupEntity.setSupplierName(mapper.getSupplierName().get());
                    }
                    if (Objects.nonNull(mapper.getSendMethodName())) {
                        orderBySupEntity.setSendMethodName(mapper.getSendMethodName().get());
                    }
                    List<String> orderCountList = supplierNameMap.get(mapper.getSupplierName().get());
                    List<String> orderTitleList = supplierNameMap.get(mapper.getTitle());
                    String waitOrderStringArugument = textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.PURCHASE_ORDER),orderCountList.size());
                    orderBySupEntity.setPurchaseCount(waitOrderStringArugument);
                    orderBySupEntity.setTitle(orderTitleList);
                    supplierList.remove(mapper.getSupplier().toString());
                    return orderBySupEntity;
                }).collect(Collectors.toList());
        switchToVendorReturnMap.put("switchToVendorData", printList);

        return switchToVendorReturnMap;
    }

    /**
     * Return first 5 orders for display by parameter's conditions
     *
     * @param userId
     *            the user id
     * @param corpId
     *            the corporation code
     * @param userSegmentValue
     *            the user segment value
     * @param type
     *            the type
     * @param supplierName
     *            the supplier name
     * @return the map
     */
    @Override
    public Map<String, Object> showInboxForExpand(String userId,
            long corpId,
            UserSegmentEnum userSegmentValue,
            String type, String supplierName) {

        List<ResponsibleOrderInboxVo> responsibleOrderEntityList = getFilteredRecords(
                userId, userSegmentValue, type, corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);
        List<ResponsibleOrderInboxVo> registrationEntityList = responsibleOrderEntityList.stream()
                .filter(predicate -> predicate.getSupplierName().equalsIgnoreCase(supplierName))
                .collect(Collectors.toList());

        return setWaitForIssuanceData(registrationEntityList, OrderManagementConstant.NUMERIC_FIVE);
    }

    /**
     * Create order views that user needs to confirm(rejected,remanded etc.)
     *
     * @param key
     *
     * @return confirmListExpandReturnMap
     */

    @Override
    public Map<String, Object> loadConfirmExpand(String key) {

        Map<String, Object> confirmListExpandReturnMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        switch (key) {
        case OrderManagementConstant.ORDER_MODIFICATION_REMANDED_ID:
            List<ResponsibleOrderInboxVo> modifiedRemandedList = getFilteredRecords(scmUserContext.getUserId()
                    .toString(),
                    UserSegmentEnum.PERSONAL, OrderManagementConstant.REMANDED,
                    corpId, OrderManagementConstant.APPLICATION,
                    OrderManagementConstant.DESCENDING);
            confirmListExpandReturnMap.put("orderDashboardExpandInboxData",
                    checkOrderModifiedRemandedStatus(modifiedRemandedList));
            break;
        case OrderManagementConstant.ORDER_ORDER_CONFIRMATION_REJECTED_ID:
            List<ResponsibleOrderInboxVo> rejectedList = getFilteredRecords(scmUserContext.getUserId().toString(),
                    UserSegmentEnum.PERSONAL,
                    OrderManagementConstant.WAITING_FOR_CONFIRMATION_ANSWER_INPUT,
                    corpId, OrderManagementConstant.APPLICATION,
                    OrderManagementConstant.DESCENDING);
            confirmListExpandReturnMap.put("orderConfirmExpandInboxData",
                    checkStatus(rejectedList, OrderManagementConstant.ORDER_CONFIRMATION_DENIED));
            break;
        case OrderManagementConstant.ORDER_REMANDED_ID:
            List<ResponsibleOrderInboxVo> remandedList = getFilteredRecords(scmUserContext.getUserId().toString(),
                    UserSegmentEnum.PERSONAL,
                    OrderManagementConstant.ON_ORDER,
                    corpId, OrderManagementConstant.APPLICATION,
                    OrderManagementConstant.DESCENDING)
                    .stream()
                    .filter(v -> StringUtils.equals(v.getOrderStatus(), OrderStatus.ORDERING_REMANDED.name()))
                    .collect(Collectors.toList());
            confirmListExpandReturnMap.put("orderDashboardExpandInboxData", checkOrderRemandedStatus(remandedList));
            break;
        case OrderManagementConstant.ORDER_ATP_ANSWER_INCLUDES_SOME_PROBLEMS:
            List<ResponsibleOrderInboxVo> responsibleOrderInboxVoList = getFilteredRecords(scmUserContext.getUserId()
                    .toString(),
                    UserSegmentEnum.PERSONAL,
                    OrderManagementConstant.WAITING_FOR_ATP_ANSWER_INPUT,
                    corpId, OrderManagementConstant.APPLICATION,
                    OrderManagementConstant.DESCENDING);
            confirmListExpandReturnMap.put("orderWaitDeliveryInboxList",
                    checkStatus(responsibleOrderInboxVoList, OrderManagementConstant.WAITING_FOR_RECEIVING));
            break;
        }

        return confirmListExpandReturnMap;
    }

    /**
     * loadDraftExpand.
     *
     * @param key
     *            the key
     * @return draftReturnMap
     */
    @Override
    public Map<String, Object> loadDraftExpand(UserSegmentEnum key) {

        long corpId = scmUserContext.getActiveCorpId();
        String dataValue = session.get(OrderManagementConstant.DATAVALUE, String.class);
        String modeValue = session.get(OrderManagementConstant.MODEVALUE, String.class);
        Map<String, Object> draftReturnMap = getDraftData(scmUserContext.getUserId().toString(),
                key, OrderManagementConstant.ON_ORDER, corpId, dataValue, modeValue);

        return draftReturnMap;
    }

    /**
     * loadTitle.
     *
     * @param userId
     *            the user id
     * @param userSegment
     *            the user segment value
     * @param typeOne
     *            the type one
     * @param corpId
     *            the corporation code
     * @return titleList
     */

    @Override
    public List<String> loadTitle(String userId, UserSegmentEnum userSegment, String typeOne,
            long corpId) {

        List<ResponsibleOrderEntity> registrationEntityList = responsibleOrderDao.getFilteredRecords(
                userId, userSegment.getValue(), typeOne);
        List<String> registrationList = registrationEntityList.stream()
                .filter(predicate -> predicate.getType().equalsIgnoreCase(OrderManagementConstant.TEMPORARY_SAVE))
                .map(mapper -> mapper.getTitle())
                .collect(Collectors.toList());

        return registrationList;
    }

    /**
     * loadProcurementList.
     *
     * @param userSegment
     *            the user segment value
     * @param type
     *            the type
     * @param dataValue
     *            the data value
     * @param modeValue
     *            the mode value
     * @return setProcurementData
     */

    @Override
    public Map<String, Object> loadProcurementList(UserSegmentEnum userSegment, String type, String dataValue,
            String modeValue) {

        long corpId = scmUserContext.getActiveCorpId();
        List<ResponsibleOrderInboxVo> registrationEntityList = getFilteredRecords(scmUserContext.getUserId()
                .toString(), userSegment, type,
                corpId, dataValue, modeValue);

        List<ResponsibleOrderInboxVo> registrationEntityFilteredList = registrationEntityList
                .stream()
                .filter(registrationEntity -> !(OrderStatus.QUOTING.name().equals(registrationEntity.getOrderStatus())))
                .collect(Collectors.toList());

        return setProcurementData(registrationEntityFilteredList);
    }

    /**
     * setProcurementData.
     *
     * @param responsibleOrderEntityList
     *
     * @param dataValue
     *
     * @param modeValue
     *
     * @return procuremntReturnMap
     */
    private Map<String, Object> setProcurementData(List<ResponsibleOrderInboxVo> responsibleOrderEntityList) {

        Map<String, Object> procuremntReturnMap = new HashMap<String, Object>();
        List<ResponsibleOrderInboxVo> procurementDataEntityList = renderStatusLabel(responsibleOrderEntityList);
        WapStatsLabelVo procurementStatLabelVo = setHeaderLabelAndCount(procurementDataEntityList,
                OrderManagementConstant.PROCUREMENT_REQUEST);
        procuremntReturnMap.put("searchStatsLabel", procurementStatLabelVo);
        procuremntReturnMap.put("orderPortalProcurementInboxData", procurementDataEntityList);

        return procuremntReturnMap;
    }

    /**
     * loadSorting.
     *
     * @param dataEntityList
     *            the data entity list
     * @param dataValue
     *            the data value
     * @param modeValue
     *            the mode value
     * @return dataEntityList
     */
    private List<ResponsibleOrderEntity> loadSorting(List<ResponsibleOrderEntity> dataEntityList,
            String dataValue, String modeValue) {

        List<ResponsibleOrderEntity> finalList = new ArrayList<>();
        List<ResponsibleOrderEntity> dataList = new ArrayList<>();
        List<ResponsibleOrderEntity> noDataList = new ArrayList<>();
        List<ResponsibleOrderEntity> sortedList = new ArrayList<>();
        switch (dataValue) {
        case OrderManagementConstant.REQUEST:
            dataList = dataEntityList.stream().filter(action -> Objects.nonNull(action.getRequestDate()))
                    .collect(Collectors.toList());
            noDataList = dataEntityList.stream().filter(action -> Objects.isNull(action.getRequestDate()))
                    .collect(Collectors.toList());
            if (modeValue.equals(OrderManagementConstant.ASCENDING)) {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateOne.getRequestDate()
                        .compareTo(dateTwo.getRequestDate())));
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            } else {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateTwo.getRequestDate()
                        .compareTo(dateOne.getRequestDate())));
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            }
            break;
        case OrderManagementConstant.DELIVERY:
            dataList = dataEntityList.stream().filter(action -> Objects.nonNull(action.getDeliveryDate()))
                    .collect(Collectors.toList());
            noDataList = dataEntityList.stream().filter(action -> Objects.isNull(action.getDeliveryDate()))
                    .collect(Collectors.toList());
            if (modeValue.equals(OrderManagementConstant.ASCENDING)) {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateOne.getDeliveryDate()
                        .compareTo(dateTwo.getDeliveryDate())));
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            } else {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateTwo.getDeliveryDate()
                        .compareTo(dateOne.getDeliveryDate())));
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            }
            break;
        case OrderManagementConstant.CASE:
            dataList = dataEntityList.stream().filter(action -> StringUtils.isNotEmpty(action.getPurchaseType()))
                    .collect(Collectors.toList());
            noDataList = dataEntityList.stream().filter(action -> StringUtils.isEmpty(action.getPurchaseType()))
                    .collect(Collectors.toList());
            Map<String, Object> purchaseProcessTypeMap = dataList.stream()
                    .map(ResponsibleOrderEntity::getPurchaseType)
                    .distinct()
                    .collect(Collectors.toMap(Function.identity(), data -> {
                        for (PurchaseProcessTypeEnum val : PurchaseProcessTypeEnum.values()) {
                            if (val.name().equals(data)) {
                                return textResourceManager.getText(TextId.of(val.getValue()));
                            }
                        }
                        return StringUtils.EMPTY;
                    }));
            Collections.sort(dataList,
                    (dateOne, dateTwo) -> (purchaseProcessTypeMap.get(dateOne.getPurchaseType()).toString()
                            .compareTo(purchaseProcessTypeMap.get(dateTwo.getPurchaseType()).toString())));
            if (modeValue.equals(OrderManagementConstant.ASCENDING)) {
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            } else {
                Collections.reverse(dataList);
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            }
            break;
        case OrderManagementConstant.APPLICATION:
            dataList = dataEntityList.stream().filter(action -> Objects.nonNull(action.getOrderDate()))
                    .collect(Collectors.toList());
            noDataList = dataEntityList.stream().filter(action -> Objects.isNull(action.getOrderDate()))
                    .collect(Collectors.toList());
            if (modeValue.equals(OrderManagementConstant.ASCENDING)) {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateOne.getOrderDate()
                        .compareTo(dateTwo.getOrderDate())));
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            } else {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateTwo.getOrderDate()
                        .compareTo(dateOne.getOrderDate())));
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            }
            break;
        case OrderManagementConstant.ORDER:
            dataList = dataEntityList.stream().filter(action -> Objects.nonNull(action.getOrderStatus()))
                    .collect(Collectors.toList());
            noDataList = dataEntityList.stream().filter(action -> Objects.isNull(action.getOrderStatus()))
                    .collect(Collectors.toList());
            if (modeValue.equals(OrderManagementConstant.ASCENDING)) {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateOne.getOrderStatus()
                        .compareTo(dateTwo.getOrderStatus())));
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            } else {
                Collections.sort(dataList, (dateOne, dateTwo) -> (dateTwo.getOrderStatus()
                        .compareTo(dateOne.getOrderStatus())));
                dataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
                noDataList.stream().forEach(dataObject -> {
                    finalList.add(dataObject);
                });
            }
            break;
        default:
            break;
        }

        return finalList;

    }

    /**
     * loadApplyOrderList.
     *
     * @param userSegment
     *            the user segment value
     * @param dataValue
     *            the data value
     * @param modeValue
     *            the mode value
     * @return the list
     */
    @Override
    public Map<String, Object> loadApplyOrderList(UserSegmentEnum userSegment, String dataValue, String modeValue,
            int currentCount) {

        Map<String, Object> applyOrderReturnMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        session.put(OrderManagementConstant.DATAVALUE, dataValue);
        session.put(OrderManagementConstant.MODEVALUE, modeValue);
        List<ResponsibleOrderInboxVo> onOrderEntityList = getFilteredRecords(scmUserContext.getUserId()
                .toString(),
                userSegment, OrderManagementConstant.ON_ORDER, corpId,
                dataValue,
                modeValue);

        List<ResponsibleOrderInboxVo> remandedDataEntityList = onOrderEntityList
                .stream()
                .filter(entity -> entity.getOrderStatus().equals(OrderStatus.ORDERING_REMANDED.name())
                        || entity.getOrderStatus().equals(OrderStatus.MODIFICATION_REMANDED.name())
                        || entity.getOrderStatus().equals(OrderStatus.CANCELLATION_REMANDED.name()))
                .collect(Collectors.toList());

        applyOrderReturnMap.putAll(setRemandData(remandedDataEntityList));

        List<ResponsibleOrderInboxVo> draftDataEntityList = onOrderEntityList
                .stream()
                .filter(entity -> entity.getOrderStatus().equals(OrderStatus.ORDERING_ON_TEMPORARY_SAVING.name())
                        || entity.getOrderStatus().equals("CANCEL_ON_TEMPORARY_SAVING"))
                .collect(Collectors.toList());
        Integer draftDataEntityListsize = draftDataEntityList.size();
        if (draftDataEntityListsize > OrderManagementConstant.NUMERIC_ZERO) {
            applyOrderReturnMap.putAll(setDraftData(draftDataEntityList, userSegment));
        }

        List<ResponsibleOrderInboxVo> applyingDataEntityList = onOrderEntityList.stream()
                .filter(entity -> entity.getOrderStatus().equals(OrderStatus.ORDERING_ON_REQUEST.name())
                        || entity.getOrderStatus().equals(OrderStatus.MODIFICATION_ON_REQUEST.name())
                        || entity.getOrderStatus().equals(OrderStatus.INNER_MODIFICATION.name())
                        || entity.getOrderStatus().equals(OrderStatus.CANCEL_ON_REQUEST.name()))
                .collect(Collectors.toList());
        applyOrderReturnMap.putAll(setApplyingData(applyingDataEntityList, currentCount));

        return applyOrderReturnMap;
    }

    /**
     * setRemandData.
     *
     * @param remandedDataEntityList
     *            the remanded data entity list
     * @param dataValue
     *            the data value
     * @param modeValue
     *            the mode value
     * @return the remandReturnMap
     */
    private Map<String, Object> setRemandData(List<ResponsibleOrderInboxVo> remandedDataEntityList) {

        Map<String, Object> remandReturnMap = new HashMap<>();
        List<ResponsibleOrderInboxVo> statusCheckEntityList = new ArrayList<>();
        statusCheckEntityList.addAll(checkOrderRemandedStatus(remandedDataEntityList));
        remandReturnMap.put("orderRemandInboxData", statusCheckEntityList);
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(statusCheckEntityList,
                OrderManagementConstant.REMAND);
        remandReturnMap.put("remandStatsLabel", wapHeaderLabelVo);

        return remandReturnMap;
    }

    /**
     * checkOrderRemandedStatus.
     *
     * @param responsibleOrderEntityList
     *            the responsible order entity list
     * @return the list
     */
    private List<ResponsibleOrderInboxVo> checkOrderRemandedStatus(
            List<ResponsibleOrderInboxVo> responsibleOrderEntityList) {

        List<ResponsibleOrderInboxVo> remandStatusReturnList = renderStatusLabel(responsibleOrderEntityList);

        return remandStatusReturnList;
    }

    /**
     * checkOrderModifiedRemandedStatus.
     *
     * @param responsibleOrderEntityList
     *            the responsible order entity list
     * @return the list
     */
    private List<ResponsibleOrderInboxVo> checkOrderModifiedRemandedStatus(
            List<ResponsibleOrderInboxVo> responsibleOrderEntityList) {

        List<ResponsibleOrderInboxVo> modifiedRemandedReturnList = renderStatusLabel(responsibleOrderEntityList);

        return modifiedRemandedReturnList;
    }

    /**
     * loadLazyForApplying is used to fetch next set of rows and perform lazy load
     *
     * @param orderManagementEntity
     *            the order management entity
     * @param userSegment
     *            the user segment value
     * @return the dataMap
     */
    @Override
    public Map<String, Object> loadLazyForApplying(OrderManagementEntity orderManagementEntity,
            UserSegmentEnum userSegment) {

        Map<String, Object> dataMap = new HashMap<>();
        String dataValue = session.get(OrderManagementConstant.DATAVALUE, String.class);
        String modeValue = session.get(OrderManagementConstant.MODEVALUE, String.class);
        long corpId = scmUserContext.getActiveCorpId();
        int currentCount = orderManagementEntity.getCurrentCount();
        int countDifference;
        AtomicInteger fetchLimit = new AtomicInteger();
        fetchLimit.set(orderManagementEntity.getFetchLimit());
        fetchLimit.set(fetchLimit.get() + currentCount);
        List<ResponsibleOrderInboxVo> applyingDataEntityList = getFilteredRecords(scmUserContext.getUserId()
                .toString(),
                userSegment, OrderManagementConstant.ON_ORDER, corpId,
                dataValue, modeValue);
        List<String> availableStatuses = Arrays.asList(
                OrderStatus.ORDERING_ON_REQUEST.name(),
                OrderStatus.MODIFICATION_ON_REQUEST.name(),
                OrderStatus.CANCEL_ON_REQUEST.name());
        List<ResponsibleOrderInboxVo> filterApplyingDataEntityList = applyingDataEntityList
                .stream()
                .filter(e -> availableStatuses.contains(e.getOrderStatus()))
                .collect(Collectors.toList());

        List<ResponsibleOrderInboxVo> inboxGroupList = renderStatusLabel(
                filterApplyingDataEntityList);
        filterApplyingDataEntityList
                .stream()
                .forEach(action -> {
                        int count = inboxGroupList.size();
                        if (count < fetchLimit.get() && (count < filterApplyingDataEntityList.size())) {
                                inboxGroupList.add(filterApplyingDataEntityList.get(count));
                        }
                });

        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList,
                OrderManagementConstant.APPLYING);
        countDifference = inboxGroupList.size() - currentCount;
        if (countDifference >= OrderManagementConstant.NUMERIC_FIVE) {
            dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                    .label(textResourceManager.getTextWithParam(
                            TextId.of(OrderManagementConstant.SEE_MORE)))
                    .build());
            dataMap.put(
                    "orderApplyingInboxListData",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount
                            + OrderManagementConstant.NUMERIC_FIVE));
        } else {
            dataMap.put(
                    "seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.NONE)
                            .label(textResourceManager.getTextWithParam(
                                    TextId.of(OrderManagementConstant.SEE_MORE)))
                            .build());
            dataMap.put(
                    "orderApplyingInboxListData",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount + countDifference));
        }
        dataMap.put("applyingStatsLabel", wapHeaderLabelVo);
        // dataMap.put("orderApplyingInboxListData", inboxGroupList);

        return dataMap;
    }

    @Override
    public Map<String, Object> loadLazyPendingOrderPending(OrderManagementEntity orderManagementEntity,
            UserSegmentEnum userSegment) {
        Map<String, Object> dataMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        String type = OrderManagementConstant.WAITING_FOR_ORDER_CONFIRMATION;
        int currentCount = orderManagementEntity.getCurrentCount();
        int countDifference;
        AtomicInteger fetchLimit = new AtomicInteger();
        fetchLimit.set(orderManagementEntity.getFetchLimit());
        fetchLimit.set(fetchLimit.get() + currentCount);
        List<ResponsibleOrderInboxVo> inboxGroupList = new ArrayList();
        List<ResponsibleOrderInboxVo> pendingDataEntityList = getFilteredRecords(
                scmUserContext.getUserId().toString(),
                userSegment, type, corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);

        pendingDataEntityList.stream().forEach(action -> {
            int count = inboxGroupList.size();
            if (count < fetchLimit.get() && (count < pendingDataEntityList.size())) {
                inboxGroupList.add(pendingDataEntityList.get(count));
            }
        });
        countDifference = pendingDataEntityList.size() - currentCount;
        if (countDifference >= OrderManagementConstant.NUMERIC_FIVE) {
            dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                    .label(textResourceManager.getTextWithParam(
                            TextId.of(OrderManagementConstant.SEE_MORE)))
                    .build());
            dataMap.put(
                    "orderPendingInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount
                            + OrderManagementConstant.NUMERIC_FIVE));
        } else {
            dataMap.put(
                    "seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.NONE)
                            .label(textResourceManager.getTextWithParam(
                                    TextId.of(OrderManagementConstant.SEE_MORE)))
                            .build());
            dataMap.put(
                    "orderPendingInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount + countDifference));
        }

        // if (pendingDataEntityList.size() == inboxGroupList.size()) {
        // dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.NONE)
        // .label(textResourceManager.getTextWithParam(
        // TextId.of(OrderManagementConstant.SEE_MORE)))
        // .build());
        // } else {
        // dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
        // .label(textResourceManager.getTextWithParam(
        // TextId.of(OrderManagementConstant.SEE_MORE)))
        // .build());
        // }
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList,
                OrderManagementConstant.SCM_PR_ORDER_WAITING_HEADER_INFO);
        dataMap.put("pendingStatsLabel", wapHeaderLabelVo);
        // dataMap.put("orderPendingInboxList", inboxGroupList);
        return dataMap;
    }

    /**
     * getDraftData Gets the draft data.
     *
     * @param userId
     *            the user id
     * @param userSegment
     *            the user segment value
     * @param type
     *            the type
     * @param corpId
     *            the corporation code
     * @param dataValue
     *            the data value
     * @param modeValue
     *            the mode value
     * @return the draft data
     */
    private Map<String, Object> getDraftData(String userId, UserSegmentEnum userSegment, String type,
            long corpId, String dataValue, String modeValue) {

        List<ResponsibleOrderInboxVo> draftDataEntityList = getFilteredRecords(userId, userSegment, type,
                corpId, dataValue,
                modeValue);
        List<ResponsibleOrderInboxVo> temporaySavingDraftDataEntityList = draftDataEntityList
                .stream()
                .filter(draftDataEntity -> draftDataEntity.getOrderStatus()
                        .equals(OrderManagementConstant.ORDERING_ON_TEMPORARY_SAVING_STATUS_TEXT_ID)
                        || draftDataEntity.getOrderStatus()
                                .equals(OrderManagementConstant.CANCEL_ON_TEMPORARY_SAVING)
                        || draftDataEntity
                                .getOrderStatus()
                                .equals(OrderManagementConstant.MODIFICATION_ON_TEMPORARY_SAVING_STATUS_TEXT_ID))
                .collect(Collectors.toList());

        return setDraftData(temporaySavingDraftDataEntityList, userSegment);
    }

    /**
     * setDraftData Sets the draft data.
     *
     * @param draftDataEntityList
     *            the draft data entity list
     * @param userSegment
     *            the user segment value
     * @param modeValue
     *            the mode value
     * @return the map
     */
    private Map<String, Object> setDraftData(List<ResponsibleOrderInboxVo> draftDataEntityList,
            UserSegmentEnum userSegment) {

        Map<String, Object> draftReturnMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        List<OrderManagementPortalEntity> orderManagementInprogressEntityList = new ArrayList<>();

        List<String> titleList = loadTitle(scmUserContext.getUserId().toString(),
                UserSegmentEnum.PERSONAL, OrderManagementConstant.TEMPORARY_SAVE, corpId);

        WapInboxIconRendererVo pencil = new WapInboxIconRendererVo.Builder().roundType(true)
                .colorType(CommonAllColorType.DEFAULT)
                .iconType(CommonIconType.PENCIL).build();

        String title = textResourceManager.getTextWithParam(
                TextId.of(OrderManagementConstant.TITLE),
                titleList);

        orderManagementInprogressEntityList.add(new OrderManagementPortalEntity(pencil,
                textResourceManager.getTextWithParam(
                        TextId.of(OrderManagementConstant.DRAFT)),
                title, scmUserContext.getUserId()
                        .toString(),
                userSegment.getValue()));

        draftReturnMap.put("orderTemporarySaveInboxListData", orderManagementInprogressEntityList);
        renderStatusLabel(draftDataEntityList);
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(draftDataEntityList,
                OrderManagementConstant.DRAFT);
        draftReturnMap.put("temporarySaveStatsLabel", wapHeaderLabelVo);
        draftReturnMap.put("orderApplyingExpandInboxData", draftDataEntityList);

        return draftReturnMap;
    }

    /**
     * loadWaitForIssuanceList.
     *
     * @param userSegment
     *            the user segment value
     * @param type
     *            the type
     * @param currentCount
     * @return the setWaitForIssuanceData
     */
    @Override
    public Map<String, Object> loadWaitForIssuanceList(UserSegmentEnum userSegment, int currentCount) {

        long corpId = scmUserContext.getActiveCorpId();

        List<ResponsibleOrderInboxVo> issuanceDataEntityList = getFilteredRecords(
                scmUserContext.getUserId().toString(),
                userSegment, OrderManagementConstant.WAITING_FOR_ORDERSHEET_PRINTING, corpId,
                OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);

        return setWaitForIssuanceData(issuanceDataEntityList, currentCount);

    }

    /**
     * setWaitForIssuanceData.
     *
     * @param responsibleOrderEntityList
     *            the responsible order entity list
     * @param currentCount
     * @return the map
     */
    private Map<String, Object> setWaitForIssuanceData(List<ResponsibleOrderInboxVo> responsibleOrderEntityList,
            int currentCount) {

        List<ResponsibleOrderInboxVo> responsibleOrderEntityWapList = new ArrayList<>();
        Map<String, Object> issuanceReturnMap = new HashMap<>();
        issuanceReturnMap.put("seeMoreAnchorLabel",
                new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                        .build());
        List<ResponsibleOrderInboxVo> approvedheaderList = renderStatusLabel(
                responsibleOrderEntityList);
        responsibleOrderEntityWapList.addAll(approvedheaderList);

        if ((!responsibleOrderEntityWapList.isEmpty())
                && (responsibleOrderEntityWapList.size() >= currentCount)) {
            issuanceReturnMap.put("waitIssuanceInboxList",
                    responsibleOrderEntityWapList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount));
        } else {
            issuanceReturnMap.put("waitIssuanceInboxList", responsibleOrderEntityWapList);
        }

        if (responsibleOrderEntityWapList.size() > currentCount) {
            issuanceReturnMap.put("seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                            .build());
        } else {
            issuanceReturnMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder()
                    .display(CommonDisplayType.NONE)
                    .build());
        }

        return issuanceReturnMap;
    }

    /**
     * loadLazyWaitIssuance is used to fetch next set of rows and perform lazy load
     *
     * @param orderManagementEntity
     *            the order management entity
     * @param userSegment
     *            the user segment value
     * @return the dataMap
     */
    @Override
    public Map<String, Object> loadLazyWaitIssuance(OrderManagementEntity orderManagementEntity,
            UserSegmentEnum userSegment) {

        Map<String, Object> dataMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        int currentCount = orderManagementEntity.getCurrentCount();
        int countDifference;
        AtomicInteger fetchLimit = new AtomicInteger();
        fetchLimit.set(orderManagementEntity.getFetchLimit());
        fetchLimit.set(fetchLimit.get() + currentCount);
        List<ResponsibleOrderInboxVo> inboxGroupList = new ArrayList<>();
        List<ResponsibleOrderInboxVo> responsibleOrderEntityWapList = new ArrayList<>();
        List<ResponsibleOrderInboxVo> issuanceDataEntityList = getFilteredRecords(
                scmUserContext.getUserId().toString(),
                userSegment, OrderManagementConstant.WAITING_FOR_ORDERSHEET_PRINTING, corpId,
                OrderManagementConstant.APPLICATION, OrderManagementConstant.DESCENDING);
        List<ResponsibleOrderInboxVo> issuanceCancelDataEntityList = getFilteredRecords(
                scmUserContext.getUserId().toString(),
                userSegment, OrderManagementConstant.WAITING_FOR_CANCEL_SHEET_PRINT, corpId,
                OrderManagementConstant.APPLICATION, OrderManagementConstant.DESCENDING);
        issuanceDataEntityList.addAll(issuanceCancelDataEntityList);

        List<ResponsibleOrderInboxVo> approvedheaderList = renderStatusLabel(
                issuanceDataEntityList);
        responsibleOrderEntityWapList.addAll(approvedheaderList);

        responsibleOrderEntityWapList.stream().forEach(action -> {
            int count = inboxGroupList.size();
            if (count < fetchLimit.get() && (count < responsibleOrderEntityWapList.size())) {
                inboxGroupList.add(responsibleOrderEntityWapList.get(count));
            }
        });
        countDifference = inboxGroupList.size() - currentCount;
        if (countDifference >= OrderManagementConstant.NUMERIC_FIVE) {
            dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                    .label(textResourceManager.getTextWithParam(
                            TextId.of(OrderManagementConstant.SEE_MORE)))
                    .build());
            dataMap.put(
                    "waitIssuanceInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount
                            + OrderManagementConstant.NUMERIC_FIVE));
        } else {
            dataMap.put(
                    "seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.NONE)
                            .label(textResourceManager.getTextWithParam(
                                    TextId.of(OrderManagementConstant.SEE_MORE)))
                            .build());
            dataMap.put(
                    "waitIssuanceInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount + countDifference));
        }

        // if (issuanceDataEntityList.size() == inboxGroupList.size()) {
        // dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.NONE)
        // .label(textResourceManager.getTextWithParam(
        // TextId.of(OrderManagementConstant.SEE_MORE)))
        // .build());
        // } else {
        // dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
        // .label(textResourceManager.getTextWithParam(
        // TextId.of(OrderManagementConstant.SEE_MORE)))
        // .build());
        // }
        //
        // dataMap.put("waitIssuanceInboxList", inboxGroupList);

        return dataMap;
    }

    /**
     * loadSwitchToVendor.
     *
     * @param userSegment
     *            the user segment
     * @return the setSwitchToVendorData
     */

    @Override
    public Map<String, Object> loadSwitchToVendor(UserSegmentEnum userSegment) {

        long corporationId = scmUserContext.getActiveCorpId();
        List<ResponsibleOrderBySupEntity> registrationEntityList = getVendorFilteredRecords(scmUserContext.getUserId()
                .toString(), corporationId,
                userSegment);
        List<ResponsibleOrderBySupEntity> registrationEntityCheckList = new ArrayList<>();
        List<ResponsibleOrderInboxVo> responsibleOrderEntityList = getFilteredRecords(
                scmUserContext.getUserId().toString(), userSegment, OrderManagementConstant.WAITING_FOR_PRINT,
                corporationId,
                OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);
        List<String> enumList = new ArrayList<>();
        enumList.add(OrderStatus.WAITING_FOR_ORDER_SHEET_PRINTING.name());
        enumList.add(OrderStatus.WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING.name());
        responsibleOrderEntityList
                .stream()
                .forEach(
                        action -> registrationEntityList
                                .stream()
                                .filter(
                                        entity -> Objects.nonNull(entity.getSupplier())
                                        && StringUtils.isNotEmpty(entity.getSupplier().toString())
                                        && StringUtils.isNotEmpty(action.getSupplier())
                                        && entity.getSupplier().toString().equals(action.getSupplier())
                                        && enumList.contains(action.getOrderStatus()))
                                .forEach(registrationEntityCheckList::add));

        return setSwitchToVendorData(registrationEntityCheckList);
    }

    /**
     * loadPendingOrderList.
     *
     * @param userSegment
     *            the user segment value
     * @param type
     *            the type
     * @param currentCount
     * @return the setPendingOrderData
     */

    @Override
    public Map<String, Object> loadPendingOrderList(UserSegmentEnum userSegment, String type, int currentCount) {

        long corpId = scmUserContext.getActiveCorpId();
        List<ResponsibleOrderInboxVo> pendingOrderPendingList = getFilteredRecords(
                scmUserContext.getUserId().toString(), userSegment, type,
                corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);
        session.put("totalRowCount", pendingOrderPendingList.size());
        return setPendingOrderData(pendingOrderPendingList, currentCount);
    }

    /**
     * setPendingOrderData Sets the pending order data.
     *
     * @param inboxGroupList
     * @param currentCount
     *
     * @return the map
     */
    private Map<String, Object> setPendingOrderData(List<ResponsibleOrderInboxVo> inboxGroupList, int currentCount) {

        Map<String, Object> pendingOrderReturnMap = new HashMap<String, Object>();
        pendingOrderReturnMap.put("seeMoreAnchorLabel",
                new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                        .build());
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList,
                OrderManagementConstant.SCM_PR_ORDER_WAITING_HEADER_INFO);
        pendingOrderReturnMap.put("pendingStatsLabel", wapHeaderLabelVo);

        if ((!inboxGroupList.isEmpty())
                && (inboxGroupList.size() >= currentCount)) {
            pendingOrderReturnMap.put("orderPendingInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount));
        } else {
            pendingOrderReturnMap.put("orderPendingInboxList", inboxGroupList);
        }

        if (inboxGroupList.size() > currentCount) {
            pendingOrderReturnMap.put("seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                            .build());
        } else {
            pendingOrderReturnMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder()
                    .display(CommonDisplayType.NONE)
                    .build());
        }

        return pendingOrderReturnMap;
    }

    /**
     * setPendingProvisionalOrderData sets the pending order data.
     *
     * @param inboxGroupList
     * @param currentCount
     *
     * @return the map
     */
    private Map<String, Object> setPendingProvisionalOrderData(List<ResponsibleOrderInboxVo> inboxGroupList,
            int currentCount) {

        Map<String, Object> provisionalOrderReturnMap = new HashMap<String, Object>();
        provisionalOrderReturnMap.put("seeMoreAnchorLabel",
                new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                        .build());
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList, PROVISIONAL_COUNT_STATUS);
        provisionalOrderReturnMap.put("provisionalStatsLabel", wapHeaderLabelVo);
        if ((CollectionUtils.isNotEmpty(inboxGroupList))
                && (inboxGroupList.size() >= currentCount)) {
            provisionalOrderReturnMap.put("orderPendingInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount));
        } else {
            provisionalOrderReturnMap.put("orderPendingInboxList", inboxGroupList);
        }

        if (inboxGroupList.size() > currentCount) {
            provisionalOrderReturnMap.put("seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                            .build());
        } else {
            provisionalOrderReturnMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder()
                    .display(CommonDisplayType.NONE)
                    .build());
        }

        return provisionalOrderReturnMap;
    }

    /**
     * setApplyingData.
     *
     * @param inboxGroupList
     *            the inbox group list
     * @param currentCount
     * @return the map
     */
    private Map<String, Object> setApplyingData(List<ResponsibleOrderInboxVo> inboxGroupList, int currentCount) {

        Map<String, Object> applyingDataReturnMap = new HashMap<>();
        applyingDataReturnMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                .build());
        List<ResponsibleOrderInboxVo> sortedApplyingList = new ArrayList<>();
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList,
                OrderManagementConstant.APPLYING);
        applyingDataReturnMap.put("applyingStatsLabel", wapHeaderLabelVo);
        List<ResponsibleOrderInboxVo> orderRequestList = renderStatusLabel(inboxGroupList);
        sortedApplyingList.addAll(orderRequestList);

        if ((!sortedApplyingList.isEmpty())
                && (sortedApplyingList.size() >= currentCount)) {
            applyingDataReturnMap.put("orderApplyingInboxListData",
                    sortedApplyingList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount));
        } else {
            applyingDataReturnMap.put("orderApplyingInboxListData", sortedApplyingList);
        }

        if (inboxGroupList.size() > currentCount) {
            applyingDataReturnMap.put("seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                            .build());
        } else {
            applyingDataReturnMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder()
                    .display(CommonDisplayType.NONE)
                    .build());
        }

        return applyingDataReturnMap;
    }

    /**
     * loadLazyWaitingForDelivery is used to fetch next set of rows and perform lazy load.
     *
     * @param orderManagementEntity
     *
     * @param userSegment
     *
     * @return the setWaitingForDeliveryData
     */
    @Override
    public Map<String, Object> loadLazyWaitingForDelivery(OrderManagementEntity orderManagementEntity,
            UserSegmentEnum userSegment) {
        Map<String, Object> dataMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        int currentCount = orderManagementEntity.getCurrentCount();
        int countDifference;
        AtomicInteger fetchLimit = new AtomicInteger();
        fetchLimit.set(orderManagementEntity.getFetchLimit());
        fetchLimit.set(fetchLimit.get() + currentCount);
        List<ResponsibleOrderInboxVo> inboxGroupList = new ArrayList<>();
        List<ResponsibleOrderInboxVo> waitingForDeliveryList = getFilteredRecords(
                scmUserContext.getUserId().toString(), userSegment,
                OrderManagementConstant.WAITING_FOR_ATP_ANSWER,
                corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);

        List<ResponsibleOrderInboxVo> filterWaitDataEntityList = waitingForDeliveryList
                .stream()
                .filter(e -> StringUtils.equals(e.getOrderStatus(),
                        OrderStatus.WAITING_FOR_ATP_ANSWER.name()))
                .collect(Collectors.toList());

        filterWaitDataEntityList.stream().forEach(action -> {
            int count = inboxGroupList.size();
            if (count < fetchLimit.get() && (count < filterWaitDataEntityList.size())) {
                inboxGroupList.add(filterWaitDataEntityList.get(count));
            }
        });
        countDifference = waitingForDeliveryList.size() - currentCount;
        if (countDifference >= OrderManagementConstant.NUMERIC_FIVE) {
            dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                    .label(textResourceManager.getTextWithParam(
                            TextId.of(OrderManagementConstant.SEE_MORE)))
                    .build());
            dataMap.put(
                    "orderWaitDeliveryInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount
                            + OrderManagementConstant.NUMERIC_FIVE));
        } else {
            dataMap.put(
                    "seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.NONE)
                            .label(textResourceManager.getTextWithParam(
                                    TextId.of(OrderManagementConstant.SEE_MORE)))
                            .build());
            dataMap.put(
                    "orderWaitDeliveryInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount + countDifference));
        }
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList,
                OrderManagementConstant.SCM_PR_ORDER_WAITING_HEADER_INFO);
        dataMap.put("waitDeliveryStatsLabel", wapHeaderLabelVo);
        // dataMap.put("orderWaitDeliveryInboxList", inboxGroupList);
        return dataMap;
    }

    /**
     * loadWaitingForDeliveryList.
     *
     * @param userSegment
     *
     * @param type
     *
     * @return the setWaitingForDeliveryData
     */

    @Override
    public Map<String, Object> loadWaitingForDeliveryList(UserSegmentEnum userSegment, String type, int currentCount) {

        long corpId = scmUserContext.getActiveCorpId();
        List<ResponsibleOrderInboxVo> waitingForDeliveryList = getFilteredRecords(
                scmUserContext.getUserId().toString(), userSegment, type,
                corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);
        List<ResponsibleOrderInboxVo> filterWaitDataEntityList = waitingForDeliveryList
                .stream()
                .filter(predicate -> predicate.getOrderStatus()
                        .equals(OrderManagementConstant.WAITING_FOR_ATP_ANSWER_STATUS_TEXT_ID))
                .collect(Collectors.toList());
        session.put("totalRowCount", filterWaitDataEntityList.size());
        return setWaitingForDeliveryData(filterWaitDataEntityList, currentCount);
    }

    /**
     * setWaitingForDeliveryData Sets the waiting for delivery data.
     *
     * @param waitingForDeliveryList
     *            the waiting for delivery list
     * @return the map
     */
    private Map<String, Object> setWaitingForDeliveryData(List<ResponsibleOrderInboxVo> waitingForDeliveryList,
            int currentCount) {

        Map<String, Object> pendingOrderReturnMap = new HashMap<String, Object>();
        pendingOrderReturnMap.put("seeMoreAnchorLabel",
                new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                        .build());
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(waitingForDeliveryList,
                OrderManagementConstant.SCM_PR_ORDER_WAITING_HEADER_INFO);
        pendingOrderReturnMap.put("waitDeliveryStatsLabel", wapHeaderLabelVo);
        if ((!waitingForDeliveryList.isEmpty())
                && (waitingForDeliveryList.size() >= currentCount)) {
            pendingOrderReturnMap.put("orderWaitDeliveryInboxList",
                    waitingForDeliveryList.subList(OrderManagementConstant.NUMERIC_ZERO,
                            currentCount));
        } else {
            pendingOrderReturnMap.put("orderWaitDeliveryInboxList", waitingForDeliveryList);
        }
        if (waitingForDeliveryList.size() > currentCount) {
            pendingOrderReturnMap.put("seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                            .build());
        } else {
            pendingOrderReturnMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder()
                    .display(CommonDisplayType.NONE)
                    .build());
        }

        return pendingOrderReturnMap;
    }

    /**
     * setHeaderLabelAndCount Sets the header label and count.
     *
     * @param responsibleOrderEntityList
     *
     * @param textIdString
     *
     * @return the wap stats label vo
     */
    private WapStatsLabelVo setHeaderLabelAndCount(List<ResponsibleOrderInboxVo> responsibleOrderEntityList,
            String textIdString) {

        String inboxCountString = String.valueOf(responsibleOrderEntityList.size());

        return setHeaderLabel(responsibleOrderEntityList, inboxCountString, textIdString);
    }

    /**
     * setHeaderLabel Sets the header label.
     *
     * @param responsibleOrderEntityList
     *
     * @param inboxCountString
     *
     * @param textIdString
     *
     * @return the wap stats label vo
     */
    private WapStatsLabelVo setHeaderLabel(List<ResponsibleOrderInboxVo> responsibleOrderEntityList,
            String inboxCountString, String textIdString) {

        WapStatsLabelVo wapHeaderLabelVo;
        if (textIdString.equals(PROVISIONAL_COUNT_STATUS)) {
            wapHeaderLabelVo = new WapStatsLabelVo.Builder()
                    .label(textResourceManager.getTextWithParam(TextId.of(PROVISIONAL_COUNT_STATUS)))
                    .value(inboxCountString).value(false)
                    .unit(textResourceManager.getTextWithParam(TextId.of("PC.POMT.recordCounts")))
                    .build();
        } else {
            wapHeaderLabelVo = new WapStatsLabelVo.Builder()
                    .label(textResourceManager.getTextWithParam(TextId.of(textIdString)))
                    .value(inboxCountString).value(false)
                    .build();
        }
        return wapHeaderLabelVo;
    }

    /**
     * renderStatusLabel Render status label.
     *
     * @param responsibleOrderEntityList
     *
     * @return the setRenderedStatusToEntity
     */
    private List<ResponsibleOrderInboxVo> renderStatusLabel(
            List<ResponsibleOrderInboxVo> responsibleOrderEntityList) {
        responsibleOrderEntityList
                .stream()
                .filter(inboxVo -> !inboxVo.getOrderStatus().isEmpty()
                        && !Arrays.asList(OrderStatus.values()).contains(inboxVo.getOrderStatus()))
                .forEach(rs -> {
                    WapInboxTagRendererVo.Builder tagBuilder = new WapInboxTagRendererVo.Builder()
                            .value(textResourceManager.getText(TextId
                                    .of(OrderStatus.valueOf(rs
                                            .getOrderStatus()).getValue())))
                            .borderRadius(true);

                    switch (OrderStatus.valueOf(rs.getOrderStatus())) {
                    case ORDERING_REMANDED:
                    case MODIFICATION_REMANDED:
                    case CANCELLATION_REMANDED:
                        rs.setStatus(tagBuilder.colorType(CommonAllColorType.DANGER).build());
                        break;
                    case PRE_ORDER_ON_WAITING_FOR_ACCEPTANCE:
                        rs.setStatus(tagBuilder.colorType(CommonAllColorType.WARNING).build());
                        break;
                    default:
                        rs.setStatus(tagBuilder.colorType(CommonAllColorType.SUCCESS).build());
                        break;
                    }
                    rs.setAllRows(responsibleOrderEntityList.size());
                });
        return responsibleOrderEntityList;
    }

    /**
     * getFilteredRecords Gets the filtered records.
     *
     * @param userId
     *            the user id
     * @param userSegment
     *            the user segment value
     * @param type
     *            the type
     * @param corpId
     *
     *            the corporation code
     * @param modeValue
     * @param dataValue
     * @return the filtered records
     */
    private List<ResponsibleOrderInboxVo> getFilteredRecords(String userId, UserSegmentEnum userSegment, String type,
            long corpId, String dataValue, String modeValue) {

        List<ResponsibleOrderInboxVo> responsibleOrderVosList = new ArrayList<>();
        UUID deptInChargeId = scmUserContext.getActiveDeptInChargeId();
        Optional<PersonInCharge> personInChargeOptional = scmUserContext.getPersonInCharge();
        UUID personInChargeId = personInChargeOptional.isPresent() ? personInChargeOptional.get().getPersonInChargeId()
                : null;
        List<ResponsibleOrderEntity> registrationEntityList;
        if (type.equals(OrderManagementConstant.WAITING_FOR_PROVISIONAL_ORDER_COMMITION)) {
            registrationEntityList = loadProvisionalData(deptInChargeId, corpId,
                    userSegment.getValue(), personInChargeId);
        } else {
            if (Objects.nonNull(deptInChargeId)) {
                registrationEntityList = responsibleOrderDao.getFilteredRecords(null, deptInChargeId, corpId,
                        userSegment.getValue(), type);
            } else if (Objects.nonNull(personInChargeId)) {
                registrationEntityList = responsibleOrderDao.getFilteredRecords(personInChargeId, null, corpId,
                        userSegment.getValue(), type);
            } else {
                return Collections.emptyList();
            }
        }
        List<ResponsibleOrderEntity> sortedList = loadSorting(registrationEntityList, dataValue, modeValue);
        sortedList.stream()
                .forEach(
                        list -> {
                            String orderNo = StringUtils.EMPTY;
                            String orderDate = StringUtils.EMPTY;
                            String deliveryDate = StringUtils.EMPTY;
                            String requestDate = StringUtils.EMPTY;
                            String savedDate = StringUtils.EMPTY;
                            String title = StringUtils.EMPTY;
                            String baseDate = StringUtils.EMPTY;
                            String cause = StringUtils.EMPTY;
                            String causeDispName = StringUtils.EMPTY;
                            String lastModified = StringUtils.EMPTY;
                            String lastUpdateUser = StringUtils.EMPTY;
                            String orderId = StringUtils.EMPTY;
                            UUID orderingEmployee = null;
                            String orderingPersonInChargeName = StringUtils.EMPTY;
                            String orderStatus = StringUtils.EMPTY;
                            String orderStatusName = StringUtils.EMPTY;
                            String productClassification = StringUtils.EMPTY;
                            String productClassificationName = StringUtils.EMPTY;
                            String purchaseType = StringUtils.EMPTY;
                            String requestor = StringUtils.EMPTY;
                            String requestorDepartment = StringUtils.EMPTY;
                            String requestorDepartmentName = StringUtils.EMPTY;
                            String requestorName = StringUtils.EMPTY;
                            String sendMethod = StringUtils.EMPTY;
                            WapInboxTagRendererVo status = new WapInboxTagRendererVo.Builder().value(StringUtils.EMPTY)
                                    .build();
                            String sendMethodName = StringUtils.EMPTY;
                            String supplier = StringUtils.EMPTY;
                            String supplierName = StringUtils.EMPTY;
                            String swServiceDefId = StringUtils.EMPTY;
                            String swServiceId = StringUtils.EMPTY;

                            loadEmptyMethod(orderNo, orderDate, deliveryDate, requestDate, savedDate, title,
                                    baseDate, cause, causeDispName, lastModified, lastUpdateUser, orderId,
                                    orderingEmployee, orderingPersonInChargeName, orderStatus, orderStatusName,
                                    productClassification, productClassificationName,
                                    purchaseType, requestor, requestorDepartment, requestorDepartmentName,
                                    requestorName, sendMethod, status,
                                    sendMethodName, supplier, supplierName, swServiceDefId, swServiceId,
                                    responsibleOrderVosList, list, corpId, type, userId);

                        });

        return responsibleOrderVosList;
    }

    /**
     * loadProvisionalData method loads provisional records.
     *
     * @param deptInChargeId
     * @param corpId
     * @param userSegment
     * @param personInChargeId
     * @return List
     */
    private List<ResponsibleOrderEntity> loadProvisionalData(UUID deptInChargeId, long corpId,
            int userSegment, UUID personInChargeId) {
        List<ResponsibleOrderEntity> registrationEntityList;
        if (Objects.nonNull(deptInChargeId)) {
            registrationEntityList = responsibleOrderDao.getFilteredRecords(null, deptInChargeId, corpId,
                    userSegment, null);
        } else if (Objects.nonNull(personInChargeId)) {
            registrationEntityList = responsibleOrderDao.getFilteredRecords(personInChargeId, null, corpId,
                    userSegment, null);
        } else {
            return Collections.emptyList();
        }
        if (CollectionUtils.isNotEmpty(registrationEntityList)) {
            return registrationEntityList
                    .stream()
                    .filter(contractFilter -> Objects.nonNull(contractFilter.getContractClassification())
                            &&
                            contractFilter.getContractClassification().equals(
                                    ContractClassification.PROVISIONAL_ORDER.toString()))
                    .filter(listFilter -> listFilter.getType().equals(
                            OrderManagementConstant.WAITING_FOR_PROVISIONAL_ORDER_COMMITION)
                            || listFilter.getType().equals(OrderManagementConstant.ON_ORDER))
                    .filter(listFilter -> listFilter.getElementType().equals(
                            OrderManagementConstant.WAITING_FOR_PROVISIONAL_ORDER_COMMITION)
                            || listFilter.getElementType().equals(OrderManagementConstant.MODIFICATION_REQUEST))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * loadEmptyMethod is used to load set the empty data
     *
     * @param orderDate
     * @param deliveryDate
     * @param requestDate
     * @param savedDate
     * @param title
     * @param baseDate
     * @param cause
     * @param causeDispName
     * @param lastModified
     * @param lastUpdateUser
     * @param orderId
     * @param orderingEmployee
     * @param orderingPersonInChargeName
     * @param orderStatus
     * @param orderStatusName
     * @param productClassification
     * @param productClassificationName
     * @param purchaseType
     * @param requestor
     * @param requestorDepartment
     * @param requestorDepartmentName
     * @param requestorName
     * @param sendMethod
     * @param status
     * @param swServiceDefId
     * @param sendMethodName
     * @param supplier
     * @param supplierName
     * @param swServiceId
     * @param responsibleOrderVos
     * @param list
     * @param corpId
     * @param type
     * @param userId
     */
    private void
            loadEmptyMethod(String orderNo, String orderDate, String deliveryDate, String requestDate,
                    String savedDate,
                    String title, String baseDate, String cause, String causeDispName, String lastModified,
                    String lastUpdateUser, String orderId, UUID orderingEmployee, String orderingPersonInChargeName,
                    String orderStatus, String orderStatusName, String productClassification,
                    String productClassificationName,
                    String purchaseType, String requestor, String requestorDepartment, String requestorDepartmentName,
                    String requestorName, String sendMethod, WapInboxTagRendererVo status, String swServiceDefId,
                    String sendMethodName, String supplier, String supplierName,
                    String swServiceId, List<ResponsibleOrderInboxVo> responsibleOrderVos,
                    ResponsibleOrderEntity list,
                    long corpId, String type, String userId) {

        StringBuilder orderDateFormat = new StringBuilder();
        StringBuilder requestDateFormat = new StringBuilder();
        StringBuilder deliveryDateFormat = new StringBuilder();
        StringBuilder savedDateFormat = new StringBuilder();
        if (Objects.nonNull(list.getSwServiceId())) {
            // swServiceId = list.getSwServiceId();
        }
        if (Objects.nonNull(list.getSwServiceDefId())) {
            swServiceDefId = list.getSwServiceDefId();
        }
        if (Objects.nonNull(list.getSupplierName())) {
            supplierName = list.getSupplierName().get();
        }
        if (Objects.nonNull(list.getSupplier())) {
            supplier = list.getSupplier().toString();
        }
        // 現状到達不能コードなので一旦コメントアウト
        // if (Objects.nonNull(list.getStatus())) {
        // status = new WapInboxTagRendererVo.Builder().value(
        // list.getStatus().toString()).build();
        // }
        if (Objects.nonNull(list.getSendMethodName())) {
            sendMethodName = list.getSendMethodName().get();
        }
        if (Objects.nonNull(list.getSendMethod())) {
            sendMethod = list.getSendMethod().toString();
        }
        if (Objects.nonNull(list.getRequestorNameML())) {
            requestorName = list.getRequestorNameML().get();
        }
        if (Objects.nonNull(list.getRequestorDepartmentName())) {
            requestorDepartmentName = list.getRequestorDepartmentName().get();
        }
        if (Objects.nonNull(list.getRequestorDepartment())) {
            requestorDepartment = list.getRequestorDepartment().toString();
        }
        if (Objects.nonNull(list.getRequestor())) {
            requestor = list.getRequestor();
        }
        if (StringUtils.isNotBlank(list.getPurchaseType())) {
            for (PurchaseProcessTypeEnum val : PurchaseProcessTypeEnum.values()) {
                if (val.name().equals(list.getPurchaseType().toUpperCase())) {
                    purchaseType = textResourceManager.getText(TextId.of(val.getValue()));
                    break;
                }
            }
        }
        if (Objects.nonNull(list.getProductClassification())) {
            productClassificationName = list.getProductClassificationName();
        }
        if (Objects.nonNull(list.getProductClassification())) {
            productClassification = list.getProductClassification().toString();
        }
        if (Objects.nonNull(list.getOrderStatusName())) {
            orderStatusName = list.getOrderStatusName().toString();
        }
        if (Objects.nonNull(list.getOrderStatus())) {
            orderStatus = list.getOrderStatus();
        }
        if (Objects.nonNull(list.getOrderingPersonInChargeId())) {
            orderingEmployee = list.getOrderingPersonInChargeId();
        }
        if (Objects.nonNull(list.getOrderingPersonInChargeName())) {
            orderingPersonInChargeName = list.getOrderingPersonInChargeName().get();
        }

        if (Objects.isNull(orderingEmployee) && StringUtils.isEmpty(orderingPersonInChargeName)) {
            orderingPersonInChargeName = getMessageWithParam(OrderManagementConstant.NOT_ASSIGNED_TEXT_ID);
        }

        if (Objects.nonNull(list.getOrderNo())) {
            orderNo = list.getOrderNo();
        }

        if (Objects.nonNull(list.getOrderId())) {
            orderId = list.getOrderId().toString();
        }
        if (Objects.nonNull(list.getLastUpdateUser())) {
            lastUpdateUser = list.getLastUpdateUser();
        }
        if (Objects.nonNull(list.getLastModified())) {
            lastModified = list.getLastModified().toString();
        }
        if (Objects.nonNull(list.getCauseDispName())) {
            causeDispName = list.getCauseDispName();
        }
        if (Objects.nonNull(list.getCause())) {
            cause = list.getCause();
        }
        if (Objects.nonNull(list.getBaseDate())) {
            baseDate = DateTimeUtils.format(LocalDate.parse(list.getBaseDate().toString()),
                    DateStyle.LONG_NO_YEAR_WITH_DAY);
        }
        if (Objects.nonNull(list.getUserId())) {
            userId = list.getUserId();
        }
        if (Objects.nonNull(list.getTitle())) {
            title = list.getTitle();
        }
        if (StringUtils.isEmpty(title)) {
            title = getMessageWithParam(OrderManagementConstant.EMPTY_TITLE_TEXT_ID);
        }

        if (Objects.nonNull(list.getOrderDate())) {
            switch (list.getType()) {
            case OrderManagementConstant.REMANDED:
                orderDate = orderDateFormat
                        .append(DateTimeUtils.format(list.getOrderDate(),
                                DateStyle.LONG_NO_YEAR_WITH_DAY))
                        .toString();
                break;
            case OrderManagementConstant.TEMPORARY_SAVE:
                orderDate = orderDateFormat
                        .append(DateTimeUtils.format(list.getOrderDate(),
                                DateStyle.LONG_NO_YEAR_WITH_DAY))
                        .toString();
                break;
            case OrderManagementConstant.REQUESTING:
                orderDate = orderDateFormat
                        .append(DateTimeUtils.format(list.getOrderDate(),
                                DateStyle.LONG_NO_YEAR_WITH_DAY))
                        .toString();
                break;
            default:
                orderDate = orderDateFormat
                        .append(DateTimeUtils.format(list.getOrderDate(),
                                DateStyle.LONG_NO_YEAR_WITH_DAY))
                        .toString();
                break;
            }
        }
        if (Objects.nonNull(list.getDeliveryDate())) {
            deliveryDate = deliveryDateFormat
                    .append(DateTimeUtils.format(list.getDeliveryDate(),
                            DateStyle.LONG_NO_YEAR_WITH_DAY))
                    .toString();
        }
        if (Objects.nonNull(list.getRequestDate())) {
            requestDate = requestDateFormat
                    .append(DateTimeUtils.format(list.getRequestDate(),
                            DateStyle.LONG_NO_YEAR_WITH_DAY))
                    .toString();
        }
        if (Objects.nonNull(list.getSavedDate())) {
            savedDate = savedDateFormat
                    .append(textResourceManager.getTextWithParam(TextId.of(OrderManagementConstant.SAVED_DATE)))
                    .append(TokenTypeIdentifier.BLANK.getIdentifierChar())
                    .append(DateTimeUtils.format(list.getSavedDate(),
                            DateStyle.LONG_NO_YEAR_WITH_DAY))
                    .toString();
        }
        ResponsibleOrderInboxVo responsibleOrderInboxVo = ResponsibleOrderInboxVo
                .builder()
                .title(title)
                .orderNo(orderNo)
                .baseDate(baseDate)
                .cause(cause)
                .causeDispName(causeDispName)
                .corpId(corpId)
                .deliveryDate(
                        deliveryDate)
                .lastModified(lastModified)
                .lastUpdateUser(lastUpdateUser)
                .orderDate(
                        orderDate)
                .orderId(orderId)
                .orderingPersonInChargeId(orderingEmployee)
                .orderingPersonInChargeName(orderingPersonInChargeName)
                .orderStatus(orderStatus)
                .orderStatusName(orderStatusName)
                .personalDiv(list.getPersonalDiv())
                .productClassification(productClassification)
                .productClassificationName(productClassificationName)
                .purchaseType(purchaseType)
                .requestDate(
                        requestDate)
                .requestor(requestor)
                .requestorDepartment(requestorDepartment)
                .requestorDepartmentName(requestorDepartmentName)
                .requestorName(requestorName)
                .savedDate(savedDate)
                .sendMethod(sendMethod).sendMethodName(sendMethodName)
                .status(status).supplier(supplier)
                .supplierName(supplierName)
                .procurementRequestNumber(list.getProcurementRequestNumber())
                .swServiceDefId(swServiceDefId).swServiceId(list.getSwServiceId())
                .type(type).userId(userId).build();
        responsibleOrderVos.add(responsibleOrderInboxVo);

    };

    /**
     * getVendorFilteredRecords.
     *
     * @param userId
     *            the user id
     * @param corporationId
     *            the corporation code
     * @param userSegment
     *            the user segment value
     * @return the vendor filtered records
     */
    private List<ResponsibleOrderBySupEntity> getVendorFilteredRecords(String userId, long corporationId,
            UserSegmentEnum userSegment) {

        List<ResponsibleOrderBySupEntity> registrationEntityList = responsibleOrderBySupDao.getVendorFilteredRecords(
                userId, corporationId, userSegment.getValue());

        return registrationEntityList;
    }

    /**
     * set personInChargeId and Name to orderPlan or order(Depends on type =="PROCUREMENT_REQUEST").
     *
     * @param orderManagementEntity
     *            the order management entity
     */
    @Override
    public void assignToUser(String orderStrId, String type) {

        UUID orderId = UUID.fromString(orderStrId);
        UserId userId = scmUserContext.getUserId();
        UUID orderPersonInChargeId = null;
        Optional<PersonInCharge> personInchargeOptional = personInChargeDao.get(userId, LocalDate.now());
        if (personInchargeOptional.isPresent()) {
            orderPersonInChargeId = personInchargeOptional.get().getPersonInChargeId();
        }
        if (type.equals(OrderManagementConstant.PROCUREMENT_REQUEST_TYPE)) {
            OrderPlanHeaderEntity orderPlanHeaderEntity = orderPlanHeaderDao.getSingle(orderId);
            List<OrderPlanDetailEntity> orderPlanDetailEntityList = orderPlanDetailDao.getAllRecords(orderId);
            if (Objects.nonNull(orderPersonInChargeId)) {
                orderPlanHeaderEntity.setOrderPersonInChargeId(orderPersonInChargeId);
                orderPlanHeaderEntity.setOrderPersonInChargeName(personInchargeOptional.get().getPersonInChargeName());
            }
            orderPlanHeaderDao.insert(orderPlanHeaderEntity);
            orderSearchRegisterService.register(orderPlanHeaderEntity.getOrderPlanId(),
                    orderPlanHeaderEntity.getOrderStatus(), orderPlanHeaderEntity, orderPlanDetailEntityList,
                    scmUserContext.getUserId());
        } else {
            OrderHeaderEntity orderHeaderEntity = orderHeaderDao.getOrderHeaderEntity(orderId);
            List<OrderDetailEntity> orderDetailEntityList = orderDetailDao.getOrderDetails(orderId);
            if (Objects.nonNull(orderPersonInChargeId)) {
                orderHeaderEntity.setOrderPersonInChargeId(orderPersonInChargeId);
                orderHeaderEntity.setOrderPersonInChargeName(personInchargeOptional.get().getPersonInChargeName());
            }
            orderHeaderDao.insert(orderHeaderEntity);
            orderSearchRegisterService.register(orderHeaderEntity.getOrderId(), orderHeaderEntity.getOrderStatus(),
                    orderHeaderEntity, orderDetailEntityList, scmUserContext.getUserId());
        }

    }

    /**
     * update orderHeader(or orderPlanHeader) data and search data after changing purchaser
     *
     * @param orderManagementEntity
     *
     */
    @Override
    public void insertChangedPurchaser(OrderManagementEntity orderManagementEntity) {
        UUID orderId = UUID.fromString(orderManagementEntity.getOrderIdList());
        String type = orderManagementEntity.getOrderTypeList();
        if (type.equals(OrderManagementConstant.PROCUREMENT_REQUEST_TYPE)) {
            OrderPlanHeaderEntity orderPlanHeaderEntity = orderPlanHeaderDao.getSingle(orderId);
            List<OrderPlanDetailEntity> orderPlanDetailEntityList = orderPlanDetailDao.getAllRecords(orderId);
            orderPlanHeaderEntity = insertToPlanHeaderEntity(orderPlanHeaderEntity, orderId, orderManagementEntity);
            orderPlanHeaderDao.insert(orderPlanHeaderEntity);
            orderSearchRegisterService.register(orderPlanHeaderEntity.getOrderPlanId(),
                    orderPlanHeaderEntity.getOrderStatus(), orderPlanHeaderEntity, orderPlanDetailEntityList,
                    scmUserContext.getUserId());
        } else {
            OrderHeaderEntity orderHeaderEntity = orderHeaderDao.getOrderHeaderEntity(orderId);
            List<OrderDetailEntity> orderDetailEntityList = orderDetailDao.getOrderDetails(orderId);
            orderHeaderEntity = insertToHeaderEntity(orderHeaderEntity, orderId, orderManagementEntity);
            orderHeaderDao.insert(orderHeaderEntity);
            orderSearchRegisterService.register(orderHeaderEntity.getOrderId(), orderHeaderEntity.getOrderStatus(),
                    orderHeaderEntity, orderDetailEntityList, scmUserContext.getUserId());
        }
    }

    /**
     * insertToHeaderEntity is used to insert into header entity.
     *
     * @param orderHeaderEntity
     *
     * @param personInChargeId
     *
     * @param orderId
     *            the order id
     * @param employeeName
     *            the employee name
     * @return the order header entity
     */
    private OrderHeaderEntity insertToHeaderEntity(OrderHeaderEntity orderHeaderEntity, UUID orderId,
            OrderManagementEntity orderManagementEntity) {
        String personInChargeIdString = orderManagementEntity.getPurchaseMasterValue();
        String departmentInChargeIdString = orderManagementEntity.getDepartmentMasterValue();
        UUID orderPersonInChargeId = UUIDValidator.isUUID(personInChargeIdString)
                ? UUID.fromString(personInChargeIdString) : null;
        UUID departmentPersonInChargeId = UUIDValidator.isUUID(departmentInChargeIdString)
                ? UUID.fromString(departmentInChargeIdString) : null;
        String purchaserValue = orderManagementEntity.getMasterInputValue();
        String departmentValue = orderManagementEntity.getDepartmentInputValue();
        if (Objects.nonNull(orderPersonInChargeId) && Objects.nonNull(departmentPersonInChargeId)) {
            Optional<PersonInCharge> personInCharge = personInChargeDao.get(orderPersonInChargeId, LocalDate.now());
            Optional<DeptInCharge> departmentInCharge = deptInChargeDao
                    .get(departmentPersonInChargeId, LocalDate.now());
            orderHeaderEntity.setOrderPlanId(orderId);
            if (personInCharge.isPresent()) {
                orderHeaderEntity.setOrderPersonInChargeName(personInCharge.get().getPersonInChargeName());
            } else {
                orderHeaderEntity.setOrderPersonInChargeName(MLString.of(purchaserValue));
            }
            if (departmentInCharge.isPresent()) {
                orderHeaderEntity.setOrderDeptInChargeName(departmentInCharge.get().getDeptInChargeName());
            } else {
                orderHeaderEntity.setOrderDeptInChargeName(MLString.of(departmentValue));
            }
            orderHeaderEntity.setOrderPersonInChargeId(orderPersonInChargeId);
            orderHeaderEntity.setOrderDeptInChargeId(departmentPersonInChargeId);
        }
        return orderHeaderEntity;

    }

    /**
     * insertToPlanHeaderEntity to detail entity.
     *
     * @param orderPlanHeaderEntity
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @param employeeName
     *            the employee name
     * @return the order plan header entity
     */
    private OrderPlanHeaderEntity
            insertToPlanHeaderEntity(OrderPlanHeaderEntity orderPlanHeaderEntity, UUID orderId,
                    OrderManagementEntity orderManagementEntity) {
        String personInChargeIdString = orderManagementEntity.getPurchaseMasterValue();
        String departmentInChargeIdString = orderManagementEntity.getDepartmentMasterValue();
        UUID orderPersonInChargeId = UUIDValidator.isUUID(personInChargeIdString)
                ? UUID.fromString(personInChargeIdString) : null;
        UUID departmentPersonInChargeId = UUIDValidator.isUUID(departmentInChargeIdString)
                ? UUID.fromString(departmentInChargeIdString) : null;
        String purchaserValue = orderManagementEntity.getMasterInputValue();
        String departmentValue = orderManagementEntity.getDepartmentInputValue();
        if (Objects.nonNull(orderPersonInChargeId) && Objects.nonNull(departmentPersonInChargeId)) {
            Optional<PersonInCharge> personInCharge = personInChargeDao.get(orderPersonInChargeId, LocalDate.now());
            Optional<DeptInCharge> departmentInCharge = deptInChargeDao
                    .get(departmentPersonInChargeId, LocalDate.now());
            orderPlanHeaderEntity.setOrderPlanId(orderId);
            if (personInCharge.isPresent()) {
                orderPlanHeaderEntity.setOrderPersonInChargeName(personInCharge.get().getPersonInChargeName());
            } else {
                orderPlanHeaderEntity.setOrderPersonInChargeName(MLString.of(purchaserValue));
            }
            if (departmentInCharge.isPresent()) {
                orderPlanHeaderEntity.setOrderDeptInChargeName(departmentInCharge.get().getDeptInChargeName());
            } else {
                orderPlanHeaderEntity.setOrderDeptInChargeName(MLString.of(departmentValue));
            }
            orderPlanHeaderEntity.setOrderPersonInChargeId(orderPersonInChargeId);
            orderPlanHeaderEntity.setOrderDeptInChargeId(departmentPersonInChargeId);
        }
        return orderPlanHeaderEntity;

    }

    /**
     * setOrderAvailabletoPromiseData is used to set the order available to promise data.
     *
     * @param orderId
     *
     */
    private void setOrderAvailabletoPromiseData(UUID orderId) {

        List<OrderDetailEntity> orderDetailEntityList = orderDetailDao.getRecordsAll(orderId);
        List<Integer> detailNumberList =  orderDetailEntityList
                .stream()
                .forEach(action -> {detailNumberList.add(action.getOrderDetailNo());
                });

        OrderAvailableToPromiseEntity orderAvailableToPromiseEntity = new OrderAvailableToPromiseEntity();
        orderAvailableToPromiseEntity.setOrderId(orderId);
        orderAvailableToPromiseEntity.setAtpId(UUID.randomUUID());
        orderAvailableToPromiseEntity.setIsAnswered(OrderManagementConstant.NUMERIC_ZERO);
        orderAvailableToPromiseEntity.setRequestDate(ZonedDateTime.now());
        orderAvailableToPromiseEntity.setLastAnnounceDate(ZonedDateTime.now());
        orderAvailableToPromiseEntity.setCorpId(scmUserContext.getActiveCorpId());

        List<AvailableToPromiseBean> availableToPromiseBeanList = detailNumberList.stream().map(action -> {
            AvailableToPromiseBean availableToPromiseBean = new AvailableToPromiseBean();
            availableToPromiseBean.setDetailNo(action);
            return availableToPromiseBean;
        }).collect(Collectors.toList());

        orderAvailableToPromiseEntity.setAtpList(availableToPromiseBeanList);

        orderAvailableToPromiseDao.insert(orderAvailableToPromiseEntity);

    }

    /**
     * setResponsibleOrderData Sets the responsible order data.
     *
     * @param orderId
     *
     */
    private void setResponsibleOrderData(UUID orderId) {

        List<ResponsibleOrderEntity> responsibleOrderEntityList = responsibleOrderDao.getAllFilteredData(orderId);
        List<Object> paramList = new ArrayList<Object>();
        responsibleOrderEntityList.forEach(responsibleOrderEntity -> {
            List<Object> paramKeyList = new ArrayList<Object>();
            paramKeyList.add(responsibleOrderEntity.getUserId());
            paramKeyList.add(responsibleOrderEntity.getType());
            paramKeyList.add(responsibleOrderEntity.getBaseDate());
            paramKeyList.add(responsibleOrderEntity.getPersonalDiv());
            paramKeyList.add(responsibleOrderEntity.getOrderId());
            paramList.add(paramKeyList);
        });
        responsibleOrderDao.deleteMultipleRows(paramList);

        responsibleOrderEntityList.forEach(responsibleOrderEntity -> {
            responsibleOrderEntity.setType(OrderManagementConstant.WAITING_FOR_ATP_ANSWER_INPUT);
            responsibleOrderEntity.setOrderStatus(OrderStatus.WAITING_FOR_ATP_ANSWER.toString());
            responsibleOrderEntity.setOrderStatusName(MLString.of(textResourceManager.getText(TextId
                    .of(OrderStatus.WAITING_FOR_ATP_ANSWER.getValue()))));
            responsibleOrderEntity.setLastModified(LocalDate.now());
            responsibleOrderEntity.setLastUpdateUser(scmUserContext.getUserId().toString());
        });

        responsibleOrderDao.insert(responsibleOrderEntityList);

    }

    /**
     * setOrderDashboardData Sets the order dashboard data.
     *
     * @param orderId
     *
     */
    private void setOrderDashboardData(UUID orderId) {

        List<OrderDashboardOngoingEntity> orderDashboardOngoingEntityList = orderDashboardOnGoingDao
                .getAllFilteredData(orderId);
        orderDashboardOnGoingDao.deleteMultipleRows(orderId);

        orderDashboardOngoingEntityList.forEach(orderDashboardOngoingEntity -> {
            orderDashboardOngoingEntity.setRowType(OrderManagementConstant.WAITING_FOR_ATP_ANSWER_STATUS_TEXT_ID);
            orderDashboardOngoingEntity.setElementType(OrderManagementConstant.WAITING_FOR_ATP_ANSWER_INPUT);
            orderDashboardOngoingEntity.setLastModified(LocalDate.now());
            orderDashboardOngoingEntity.setLastUpdateUser(scmUserContext.getUserId().toString());
        });

        orderDashboardOnGoingDao.insert(orderDashboardOngoingEntityList);

    }

    /**
     * zipFormattedData will return the data to be downloaded in zip format.
     *
     * @param orderIdList
     *
     * @param isDownload
     *
     * @param valueList
     *
     * @return zipFormattedMap
     */
    @Override
    @Transactional
    public Map<String, Object> zipFormattedData(List<String> orderIdList, String isDownload) {

        ReportSettingEntities entities = orderIdList
                .stream()
                .map(UUID::fromString)
                .map(orderId -> {
                    switch (isDownload) {
                    case "Download":
                        return orderReportService.prepareDefaultReportEntitiesForPdf(orderId);
                    case "Print":
                        return orderReportService.prepareDefaultReportEntitiesForPrint(orderId);
                    default:
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .reduce(new ReportSettingEntities(), (e1, e2) -> e1.merge(e2), (e1, e2) -> e1.merge(e2));

        return entities.toZipFormattedMap();
    }

    /**
     * loadDialogData Load dialog data loads the details to be download in dialog.
     *
     * @param orderManagementEntity
     *
     * @return the list
     */

    @Override
    public Tuple2<List<ProcurementReceiptEntity>, WapTextLabelVo> loadDialogData(
            OrderManagementEntity orderManagementEntity) {
        List<String> orderIdList = orderManagementEntity.getPrintsDialogDataList();
        Function<UUID, ProcurementReceiptEntity> mapper = new Function<UUID, ProcurementReceiptEntity>() {
            @Override
            public ProcurementReceiptEntity apply(UUID t) {
                OrderHeaderEntity entity = orderHeaderDao.getOrderHeaderEntity(t);
                List<OrderDetailEntity> details = orderDetailDao.getOrderDetails(t);
                return createRecieptEntity(entity, details);
            }
        };
        List<ProcurementReceiptEntity> list = orderIdList.stream().map(st -> UUID.fromString(st)).map(mapper)
                .collect(Collectors.toList());
        WapTextLabelVo errorLabelVo;
        if (list.stream().noneMatch(e -> e.isHasMustReport())) {
            errorLabelVo = new WapTextLabelVo.Builder().messageType(CommonMessageType.ERROR)
                    .display(CommonDisplayType.DISPLAYED).wapIcon(WapIconType.WARNING)
                    .label(textResourceManager.getText(OrderReportUsageConstants.TEXT_ID_NONE_IS_AVAILABLE)).build();
        } else if (list.stream().anyMatch(e -> !e.isHasMustReport())) {
            errorLabelVo = new WapTextLabelVo.Builder().messageType(CommonMessageType.WARNING)
                    .display(CommonDisplayType.DISPLAYED).wapIcon(WapIconType.WARNING)
                    .label(textResourceManager.getText(OrderReportUsageConstants.TEXT_ID_SOME_IS_NOT_AVAILABLE))
                    .build();
        } else {
            errorLabelVo = new WapTextLabelVo.Builder().display(CommonDisplayType.NONE).build();
        }

        return Tuple2.of(list, errorLabelVo);
    }

    /**
     * getMessageWithParam is used to get the message with Param.
     *
     * @param textId
     *
     * @return value
     */
    private String getMessageWithParam(String textId) {
        return textResourceManager.getText(TextId.of(textId));

    }

    @Override
    public Map<String, Object> loadBarcodeRecords(List<String> orderBarcodeList) {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, Object>> collectiveOrderList = new ArrayList<>();
        orderBarcodeList
                .stream()
                .forEach(
                        orderBarcodeListAction -> {
                            String[] barcodeNumber = orderBarcodeListAction.split("-(?=[^-]+$)");
                            String orderNumber = barcodeNumber[0];
                            int revisionNumber = Integer.parseInt(barcodeNumber[OrderManagementConstant.NUMERIC_ONE]);
                            OrderHeaderEntity orderHeaderEntity = orderHeaderDao
                                    .getSingleByOrderNumber(orderNumber);
                            returnMap.putAll(loadBarcodeInboxList(orderHeaderEntity, revisionNumber,
                                    collectiveOrderList));
                        });
        returnMap.put("collectiveOrderInboxListData", collectiveOrderList);
        return returnMap;
    }

    /**
     * downloadSelectedData downloads selected data.
     *
     * @param dataValue
     *
     * @param listValue
     * @return the map
     */
    @Override
    @Transactional
    public Map<String, Object> downloadSelectedData(UUID orderId, List<String> listValue) {
        return orderReportService.prepareDefaultReportEntitiesForPdf(orderId).toZipFormattedMap();
    }

    /**
     * printSelectedData prints the selected data.
     *
     * @param orderId
     *
     * @return the map
     */
    @Override
    @Transactional
    public Map<String, Object> printSelectedData(List<String> orderIdStrings) {
        ReportSettingEntities entities = orderIdStrings
                .stream()
                .map(UUID::fromString)
                .map(orderId -> orderReportService
                        .prepareDefaultReportEntitiesForPrint(orderId))
                .filter(Objects::nonNull)
                .reduce(new ReportSettingEntities(), (e1, e2) -> e1.merge(e2), (e1, e2) -> e1.merge(e2));
        return entities.toZipFormattedMap();
    }

    /**
     * inputContractDate function is used to insert the date of contract
     *
     * @param orderManagementEntity
     *
     */
    @Override
    public void inputContractDate(OrderManagementEntity orderManagementEntity) {

        String dateValue = orderManagementEntity.getRedeemValue();
        LocalDate localDate = LocalDate.parse(dateValue, DateTimeUtils.DEFAULT_DATE_FORMATTER);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, LocalTime.now(), ZoneId.systemDefault());
        UUID orderId = UUID.fromString(orderManagementEntity.getOrderIdList());

        OrderHeaderEntity orderHeaderEntity = orderHeaderDao.getOrderHeaderEntity(orderId);
        List<OrderDetailEntity> orderDetailEntityList = orderDetailDao.getOrderDetails(orderId);
        orderHeaderEntity.setOrderStatus(OrderStatus.WAITING_FOR_ATP_ANSWER.toString());
        orderHeaderEntity.setOrderStatusName(MLString.of(textResourceManager.getText(TextId
                .of(OrderStatus.WAITING_FOR_ATP_ANSWER.getValue()))));
        orderHeaderEntity.setOrderConfirmationDate(zonedDateTime);
        orderHeaderEntity.setLastModified(LocalDate.now());
        orderHeaderEntity.setLastupdateUserId(scmUserContext.getUserId().toString());
        orderHeaderDao.insert(orderHeaderEntity);
        orderSearchRegisterService.register(orderId, orderHeaderEntity.getOrderStatus(), orderHeaderEntity,
                orderDetailEntityList, scmUserContext.getUserId());

        orderConfirmationService.setOrderConfirmationData(orderId);
        setOrderAvailabletoPromiseData(orderId);
        setResponsibleOrderData(orderId);

        orderStatusControlService.updateRowTypeAndElementTypeOnGoingAfterStatusChangeOnHeader(
                orderHeaderEntity.getOrderId(),
                OrderDashboardOngoingDtoRowType.WAITING_FOR_ATP_ANSWER.toString(),
                OrderDashboardOngoingDtoElementType.WAITING_FOR_ATP_ANSWER_INPUT.toString());

    }

    /**
     * insertData method is used to update the date.
     *
     * @param SessionList
     *
     * @param OrderManagementEntity
     *
     *
     */
    @Override
    public void insertData(List<String> sessionList, OrderManagementEntity orderManagementEntity) {

        List<String> orderIdList = new ArrayList<String>();

        List<Map<String, Object>> gridDataList = orderManagementEntity.getGridData();

        String keyDate = OrderManagementConstant.ZONEDATEKEY;
        Map<String, Object> businessDataMap = new HashMap<>();
        gridDataList.forEach(item -> {
            ZonedDateTime submsissionDate = getZonedDate(item.get("orderDate"));
            businessDataMap.put(keyDate, submsissionDate);

        });
        sessionList.forEach(action -> {
            orderIdList.add(action);
        });
        List<OrderHeaderEntity> orderHeaderEntityRecordsList = orderHeaderDao.getMultiple(orderIdList);
        orderHeaderEntityRecordsList.forEach(action -> {
            ZonedDateTime submsissionDate = (ZonedDateTime)businessDataMap.get(keyDate);

            action.setOrderConfirmationDate(submsissionDate);
            action.setOrderStatus(String.valueOf(OrderStatus.WAITING_FOR_ATP_ANSWER));
            action.setOrderStatusName(MLString.of(textResourceManager.getText(TextId
                    .of(OrderStatus.WAITING_FOR_ATP_ANSWER.getValue()))));
            action.setLastModified(LocalDate.now());
            action.setLastupdateUserId(scmUserContext.getUserId().toString());
        });

        orderHeaderDao.insertMultiple(orderHeaderEntityRecordsList);
        List<OrderConfirmationAnswerEntity> orderConfirmationAnswerEntityList = orderConfirmationAnswerDao.getAll();

        Set<String> orderSet = new HashSet<>();
        orderSet.addAll(sessionList);
        orderConfirmationAnswerEntityList
                .stream()
                .filter(orderConfirmationAnswerEntity -> orderSet.contains(orderConfirmationAnswerEntity.getOrderId()
                        .toString()))
                .forEach(orderConfirmationAnswerEntity -> {
                    orderConfirmationAnswerEntity.setConfirmationId(orderConfirmationAnswerEntity.getConfirmationId());
                    orderConfirmationAnswerEntity.setIsAnswered(OrderManagementConstant.NUMERIC_ONE);
                    orderConfirmationAnswerEntity.getConfirmationAnswerList().forEach(action -> {
                        action.setIsOk(OrderManagementConstant.NUMERIC_ONE);
                    });
                });
        orderConfirmationAnswerDao.insertMultiple(orderConfirmationAnswerEntityList);

        sessionList.forEach(orderId -> {
            setOrderAvailabletoPromiseData(UUID.fromString(orderId));
            setResponsibleOrderData(UUID.fromString(orderId));
            setOrderDashboardData(UUID.fromString(orderId));
        });

    }

    /**
     * getZonedDate method used to cast objectType into a valid ZonedDateTime.
     *
     * @param objectValue
     *            the object value
     * @return ZonedDateTime
     *
     */
    public static ZonedDateTime getZonedDate(Object objectValue) {
        ZonedDateTime result = ZonedDateTime.now();
        if (StringUtils.isNotEmpty(objectValue.toString().trim())) {
            Date date = new Date();
            try {
                date = new SimpleDateFormat(OrderManagementConstant.YYYY_MM_DD).parse(objectValue.toString());
            } catch (ParseException exception) {
                exception.printStackTrace();
            }
            result = ZonedDateTime.ofInstant(date.toInstant(), TimeZone.getDefault().toZoneId());
        }
        return result;
    }

    /**
     * loadOrderDate function is used to insert the date of order
     *
     * @param orderBarcodeList
     * @param returnMap
     * @return returnMap
     *
     */
    @Override
    public Map<String, Object> loadOrderDate(List<String> orderBarcodeList, Map<String, Object> returnMap) {

        List<Map<String, Object>> collectiveOrderList = new ArrayList<Map<String, Object>>();

        List<String> orderIdList = new ArrayList<String>();
        orderBarcodeList.forEach(action -> {
            orderIdList.add(action);
        });
        List<OrderHeaderEntity> orderHeaderEntityRecordsList = orderHeaderDao.getMultiple(orderIdList);
        orderHeaderEntityRecordsList.forEach(action -> {
            Map<String, Object> dataValuesMap = new HashMap<>();
            dataValuesMap.put("orderNumber", action.getOrderNo());
            dataValuesMap.put("orderTitle", action.getOrderTitle());
            if (Objects.nonNull(action.getSupplierName())) {
                dataValuesMap.put("supplierName", action.getSupplierName().get());
            }
            if (Objects.nonNull(action.getTotalTaxIncludedAmount())) {
                dataValuesMap.put("totalTaxIncludedAmount", action.getTotalTaxIncludedAmount()
                        .toString());
            }
            collectiveOrderList.add(dataValuesMap);
        });
        returnMap.put("placementOrderGrid", collectiveOrderList);

        return returnMap;
    }

    /**
     * loadDialogDataValue Load dialog data value.
     *
     * @param orderManagementEntity
     *            the order management entity
     * @return procurementReceiptEntitiyList
     */
    @Override
    public Tuple2<List<ProcurementReceiptEntity>, WapTextLabelVo> loadDialogDataValue(
            OrderManagementEntity orderManagementEntity) {
        UUID orderId = UUID.fromString(orderManagementEntity.getOrderId());
        List<ProcurementReceiptEntity> procurementReceiptEntityList = new ArrayList<>();
        OrderHeaderEntity orderHeaderEntity = orderHeaderDao.getOrderHeaderEntity(orderId);
        List<OrderDetailEntity> orderDetailEntityList = orderDetailDao.getOrderDetails(orderId);
        ProcurementReceiptEntity procurementReceiptEntity = createRecieptEntity(orderHeaderEntity,
                orderDetailEntityList);
        procurementReceiptEntityList.add(procurementReceiptEntity);
        WapTextLabelVo errorLabelVo;
        if (!procurementReceiptEntity.isHasMustReport()) {
            errorLabelVo = new WapTextLabelVo.Builder().messageType(CommonMessageType.ERROR)
                    .display(CommonDisplayType.DISPLAYED).wapIcon(WapIconType.WARNING)
                    .label(textResourceManager.getText(OrderReportUsageConstants.TEXT_ID_NONE_IS_AVAILABLE)).build();
        } else {
            errorLabelVo = new WapTextLabelVo.Builder().display(CommonDisplayType.NONE).build();
        }
        return Tuple2.of(procurementReceiptEntityList, errorLabelVo);
    }

    private ProcurementReceiptEntity createRecieptEntity(OrderHeaderEntity orderHeaderEntity,
            List<OrderDetailEntity> orderDetailEntityList) {
        ProcurementReceiptEntity procurementReceiptEntity = new ProcurementReceiptEntity();
        Locale locale = scmUserContext.getLocale();

        procurementReceiptEntity.setOrderId(orderHeaderEntity.getOrderId());
        procurementReceiptEntity.setOrderTitle(orderHeaderEntity.getOrderTitle());
        procurementReceiptEntity.setDesiredDeliveryDate(convertToLocalDate(orderHeaderEntity
                .getDesiredDeliveryDateTime()));
        procurementReceiptEntity.setDesiredDeliveryDateString(Objects.nonNull(orderHeaderEntity
                .getDesiredDeliveryDateTime())
                ? DateTimeUtils.format(convertToLocalDate(orderHeaderEntity.getDesiredDeliveryDateTime()),
                        DateStyle.LONG)
                : StringUtils.EMPTY);
        procurementReceiptEntity.setTotalTaxIncludedAmount(NumberFormat.getNumberInstance().format(
                orderHeaderEntity.getTotalTaxIncludedAmount()));
        procurementReceiptEntity.setPurposeOfPurchase(orderHeaderEntity.getPurposeOfPurchase());
        if (Objects.nonNull(orderHeaderEntity.getSupplierName())) {
            procurementReceiptEntity.setSupplierName(orderHeaderEntity.getSupplierName().get());
        }
        StringBuilder nameList = new StringBuilder();
        ListIterator<OrderDetailEntity> it = orderDetailEntityList.listIterator();
        while (it.hasNext()) {
            OrderDetailEntity entity = it.next();
            if (entity.getItemNameML() != null) {
                nameList.append(entity.getItemNameML().get(locale));
                if (it.hasNext()) {
                    nameList.append(textResourceManager.getText(TextId.of(OrderManagementConstant.PC_POMT_COMMA)));
                }
            }
        }
        procurementReceiptEntity.setItemName(nameList.toString());
        List<Tuple2<OrderReportType, Boolean>> decisionResult = reportUsageDecisionService
                .decideAll(orderHeaderEntity, orderDetailEntityList);
        procurementReceiptEntity
                .setHasMustReport(decisionResult != null && decisionResult.stream().anyMatch(t -> t.e2));
        if (!procurementReceiptEntity.isHasMustReport()) {
            procurementReceiptEntity.setTotalTaxIncludedAmount(textResourceManager
                    .getText(OrderReportUsageConstants.TEXT_ID_NO_REPORT_TO_PRINT_ROW));
        }

        return procurementReceiptEntity;
    }

    /**
     * convertToLocalDate converts ZonedDateTime to LocalDate
     *
     * @param desiredDeliveryDateTime
     *            as ZonedDateTime
     * @return desiredDeliveryDateTime as LocalDate
     */
    private LocalDate convertToLocalDate(ZonedDateTime desiredDeliveryDateTime) {
        if (Objects.isNull(desiredDeliveryDateTime)) {
            return null;
        }
        return ZonedDateTime.ofInstant(desiredDeliveryDateTime.toInstant(),
                context.getZoneId()).toLocalDate();
    }

    /**
     * performAutoComplete performs auto complete.
     *
     * @param query
     *            the query
     * @param caretPosition
     *            the caret position
     * @return the list
     */
    @Override
    public List<Map<String, String>> performAutoComplete(String keyword, int caretPosition) {

        List<AutocompleteTypeSetting> typeSettingsList = new ArrayList<>();
        List<String> fetchFieldList = OrderManagementConstant.SEARCH_FETCH_FIELD_LIST;
        AutocompleteEntity autocompleteEntity = new AutocompleteEntity();
        autocompleteEntity.setPrefix(keyword);
        autocompleteEntity.setCaretPosition(caretPosition);
        AutocompleteTypeSetting typeSetting = new AutocompleteTypeSetting();
        typeSetting.setType(OrderManagementConstant.SCM_PROCUREMENT_PURCHASE_ORDER_SEARCH);
        typeSetting.setSearchGroupName(OrderManagementConstant.AC);
        typeSetting.setFetchFields(fetchFieldList);

        typeSetting.setMapper(new HitDocumentResponseMapper());
        typeSettingsList.add(typeSetting);
        Autocompleter autocompleter = factory.create(typeSettingsList);
        AutocompleteResult result = autocompleter.search(autocompleteEntity);
        Map<String, Object> docsMap = result.getHitDocs();
        FullTextSearchResult customerNameList = (FullTextSearchResult)docsMap
                .get(OrderManagementConstant.SCM_PROCUREMENT_PURCHASE_ORDER_SEARCH);
        List<Map<String, String>> dataList = customerNameList
                .getHits()
                .stream()
                .map(mapper -> {
                    Map<String, String> autoCompleteMap = new HashMap<>();

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder
                            .append(Objects.toString(mapper.getDocField().get(OrderManagementConstant.ORDER_TITLE)))
                            .append(StringUtils.SPACE)
                            .append(Objects.toString(mapper.getDocField()
                                    .get(OrderManagementConstant.ORDER_STATUS_JSON)));

                    String statusString = stringBuilder.toString();
                    autoCompleteMap.put(
                            "text", statusString);
                    autoCompleteMap.put("icon", OrderManagementConstant.SEARCH);
                    autoCompleteMap.put(
                            "value", statusString);
                    return autoCompleteMap;
                }).collect(Collectors.toList());

        return dataList;
    }

    /**
     * replaceHighlight replaces Highlight
     *
     * @param keyword
     * @param columnValue
     * @return columnValue
     */
    private String replaceHighlight(String keyword, String columnValue) {
        if (StringUtils.isEmpty(columnValue)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.isEmpty(keyword)) {
            return columnValue;
        }

        AtomicReference<String> stringValue = new AtomicReference<>();
        stringValue.set(columnValue);

        Stream.of(keyword.split(StringUtils.SPACE))
                .filter(StringUtils::isNotBlank)
                .forEach(
                        splitValue -> {
                            StringBuilder highlightTag = new StringBuilder();
                            if (StringUtils.containsIgnoreCase(stringValue.toString(), splitValue)) {
                                int indexValue = StringUtils.indexOfIgnoreCase(stringValue.toString(), splitValue);
                                String highlightString = stringValue.toString().substring(indexValue,
                                        indexValue + splitValue.length());
                                highlightTag.append(OrderManagementConstant.TAG_OPEN)
                                        .append(StringEscapeUtils.escapeXml10(highlightString))
                                        .append(OrderManagementConstant.TAG_CLOSE);
                                stringValue.set(stringValue.toString()
                                        .replace(highlightString, highlightTag.toString()));
                            }
                        });
        return stringValue.toString().replace(OrderManagementConstant.TAG_OPEN,
                OrderManagementConstant.HIGHLIGHT_TAG_START)
                .replace(OrderManagementConstant.TAG_CLOSE,
                        OrderManagementConstant.HIGHLIGHT_TAG_END);
    }

    /**
     * getSwitchToVendorPrintOrderId gets the switch to vendor print order id.
     *
     * @param userId
     *            the user id
     * @param corpId
     *            the corporation code
     * @param userSegment
     *            the user segment value
     * @param waitingForPrint
     *            the waiting for print
     * @param paramMapList
     *            the param map list
     * @return the switch to vendor print order id
     */
    @Override
    public List<ProcurementReceiptEntity> getSwitchToVendorPrintOrderId(String userId, long corpId,
            UserSegmentEnum userSegment,
            String type, List<String> supplierNameList) {

        List<String> orderIdList = new ArrayList<>();
        OrderManagementEntity orderManagementEntity = new OrderManagementEntity();

        List<ResponsibleOrderEntity> responsibleOrderEntityList = responsibleOrderDao.getFilteredRecords(userId,
                userSegment.getValue(), type);
        responsibleOrderEntityList.stream()
                .forEach(
                        responsibleOrderEntity -> {
                            supplierNameList
                                    .stream()
                                    .filter(supplierName -> supplierName.equals(responsibleOrderEntity
                                            .getSupplierName().get()))
                                    .map(supplierName -> {
                                        return orderIdList.add((responsibleOrderEntity.getOrderId()).toString());
                                    }).collect(Collectors.toList());
                        });
        orderManagementEntity.setPrintsDialogDataList(orderIdList);

        return loadDialogData(orderManagementEntity).e1;

    }

    @Override
    public ServiceId getDetailServiceIdFromInputServiceId(ServiceManager serviceManager, String serviceId) {
        ServiceLinkId serviceLinkIdInputToDetail = ProcurementServiceLinks.ORDER_INPUT_TO_DETAIL.getServiceLinkId();
        ServiceId linkedServiceId = null;
        List<ServiceId> serviceIds = Arrays.asList(ServiceId.valueOf(serviceId));
        // Since getServiceLinkCfg(serviceId) method doesn't work well, we need to use getCfgs method.
        // @see https://hue-redmine/redmine/issues/561528
        // TODO after the getCfg fixed, replace it.
        List<ServiceLinkCfgDto> serviceLinkCfgDtos = serviceManager.getServiceLinkCfgs(serviceIds);
        if (Objects.nonNull(serviceLinkCfgDtos)) {
            for (ServiceLinkCfgDto serviceLinkCfgDto : serviceLinkCfgDtos) {
                if (!Objects.isNull(serviceLinkCfgDto)
                        && serviceLinkCfgDto.getServiceLinkId().equals(serviceLinkIdInputToDetail)) {
                    linkedServiceId = serviceLinkCfgDto.getLinkServiceId();
                }
            }
        }
        return linkedServiceId;
    }

    @Override
    public Map<String, Object> loadLazyProvisionalOrderPending(OrderManagementEntity orderManagementEntity,
            UserSegmentEnum userSegment) {
        Map<String, Object> dataMap = new HashMap<>();
        long corpId = scmUserContext.getActiveCorpId();
        String type = OrderManagementConstant.WAITING_FOR_PROVISIONAL_ORDER_COMMITION;
        int currentCount = orderManagementEntity.getCurrentCount();
        int countDifference;
        AtomicInteger fetchLimit = new AtomicInteger();
        fetchLimit.set(orderManagementEntity.getFetchLimit());
        fetchLimit.set(fetchLimit.get() + currentCount);
        List<ResponsibleOrderInboxVo> inboxGroupList = new ArrayList();
        List<ResponsibleOrderInboxVo> pendingDataEntityList = getFilteredRecords(
                scmUserContext.getUserId().toString(),
                userSegment, type, corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);
        pendingDataEntityList.stream().forEach(action -> {
            int count = inboxGroupList.size();
            if (count < fetchLimit.get() && (count < pendingDataEntityList.size())) {
                inboxGroupList.add(pendingDataEntityList.get(count));
            }
        });
        countDifference = pendingDataEntityList.size() - currentCount;
        if (countDifference >= OrderManagementConstant.NUMERIC_FIVE) {
            dataMap.put("seeMoreAnchorLabel", new WapButtonVo.Builder().display(CommonDisplayType.DISPLAYED)
                    .label(textResourceManager.getTextWithParam(
                            TextId.of(OrderManagementConstant.SEE_MORE)))
                    .build());
            dataMap.put(
                    "orderPendingInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount
                            + OrderManagementConstant.NUMERIC_FIVE));
        } else {
            dataMap.put(
                    "seeMoreAnchorLabel",
                    new WapButtonVo.Builder().display(CommonDisplayType.NONE)
                            .label(textResourceManager.getTextWithParam(
                                    TextId.of(OrderManagementConstant.SEE_MORE)))
                            .build());
            dataMap.put(
                    "orderPendingInboxList",
                    inboxGroupList.subList(OrderManagementConstant.NUMERIC_ZERO, currentCount + countDifference));
        }
        WapStatsLabelVo wapHeaderLabelVo = setHeaderLabelAndCount(inboxGroupList, PROVISIONAL_COUNT_STATUS);
        dataMap.put("provisionalStatsLabel", wapHeaderLabelVo);
        return dataMap;
    }

    /**
     * inputGroupContractDate function is used to insert the date of contract
     *
     * @param orderManagementEntityList
     *
     */
    @Override
    public void inputGroupContractDate(OrderManagementEntity orderManagementEntity) {
        String redeemDateValue = orderManagementEntity.getRedeemValue();
        LocalDate localDate = LocalDate.parse(redeemDateValue, DateTimeUtils.DEFAULT_DATE_FORMATTER);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, LocalTime.now(), ZoneId.systemDefault());
        if (orderManagementEntity.isDetailMode()) {
            orderManagementEntity.getOrderIdDataList().stream()
                    .forEach(action -> insertContractDateForBarcode(action, zonedDateTime));
        } else {
            insertContractDateForBarcode(orderManagementEntity.getOrderIdList(), zonedDateTime);
        }
    }

    /**
     * loadBarcodeInboxList function is used to load the barcode confirmation data
     *
     * @param orderHeaderEntityRecords
     * @param revisionNumber
     * @param collectiveOrderList
     * @return returnMap
     */
    private Map<String, Object> loadBarcodeInboxList(OrderHeaderEntity orderHeaderEntity, int revisionNumber,
            List<Map<String, Object>> collectiveOrderList) {
        String orderStatusTextInput = "orderStatusHiddenInput";
        Map<String, Object> returnMap = new HashMap<>();
        if (Objects.nonNull(orderHeaderEntity)
                && orderHeaderEntity.getCorpId().equals(scmUserContext.getActiveCorpId())) {
            if (orderHeaderEntity.getOrderStatus().equals(
                    String.valueOf(OrderStatus.WAITING_FOR_CONFIRMATION))) {
                if (orderHeaderEntity.getOrderRevisionNumber() == revisionNumber) {
                    collectiveOrderList.addAll(fetchBarcodeRecords(orderHeaderEntity));
                } else {
                    returnMap.put(orderStatusTextInput,
                            textResourceManager.getTextWithParam(
                                    TextId.of("PROC.POMT.orderapplicationmodified")));
                }
            } else if (orderHeaderEntity.getOrderStatus().equals(
                    String.valueOf(OrderStatus.WAITING_FOR_ATP_ANSWER))
                    || orderHeaderEntity
                            .getOrderStatus().equals(
                                    String.valueOf(OrderStatus.WAITING_FOR_ORDER_MATCHING))) {
                returnMap.put(orderStatusTextInput,
                        textResourceManager.getTextWithParam(
                                TextId.of(OrderManagementConstant.ACCEPTED)));
            } else {
                returnMap.put(orderStatusTextInput,
                        textResourceManager.getTextWithParam(
                                TextId.of("PROC.POMT.ordernotavailable")));
            }
        } else {
            returnMap.put(orderStatusTextInput,
                    textResourceManager.getTextWithParam(
                            TextId.of("PROC.POMT.ordernotavailable")));
        }
        return returnMap;
    }

    /**
     * fetchBarcodeRecords method is used to fetch the records for corresponding orderId
     *
     * @param orderHeaderEntityRecords
     * @return collectiveOrderList
     */
    private List<Map<String, Object>> fetchBarcodeRecords(OrderHeaderEntity orderHeaderEntity) {
        List<Map<String, Object>> collectiveOrderList = new ArrayList<>();
        OrderDashboardOngoingEntity orderDashboardOngoingEntity = orderDashboardOnGoingDao
                .getAllFilteredData(orderHeaderEntity.getOrderId())
                .get(0);
        Map<String, Object> dataValuesMap = setBarcodeRecords(orderHeaderEntity, orderDashboardOngoingEntity);
        collectiveOrderList.add(dataValuesMap);
        return collectiveOrderList;
    }

    /**
     * setBarcodeRecords method is used to set the records for barcode inbox
     *
     * @param orderHeaderEntityRecords
     * @param orderDashboardOngoingEntity
     * @return dataValuesMap
     */
    private Map<String, Object> setBarcodeRecords(OrderHeaderEntity orderHeaderEntity,
            OrderDashboardOngoingEntity orderDashboardOngoingEntity) {
        Map<String, Object> dataValuesMap = new HashMap<>();
        dataValuesMap.put("orderSubject", orderHeaderEntity.getOrderTitle());
        dataValuesMap.put("orderId", orderHeaderEntity.getOrderId());
        dataValuesMap.put("orderNo", orderHeaderEntity.getOrderNo());
        dataValuesMap.put("swServiceId", orderHeaderEntity.getServiceId());
        dataValuesMap.put(
                "orderNumber",
                orderHeaderEntity.getOrderNo()
                        + TokenTypeIdentifier.MINUS.getIdentifierChar()
                        + orderHeaderEntity.getOrderRevisionNumber());
        if (Objects.nonNull(orderHeaderEntity.getSupplierName())) {
            dataValuesMap.put("supplierName", orderHeaderEntity
                    .getSupplierName().get());
        }
        if (Objects.nonNull(orderHeaderEntity.getOrderPersonInChargeName())) {
            dataValuesMap.put("userId", orderHeaderEntity.getOrderPersonInChargeName().get());
        }
        if (Objects.nonNull(orderDashboardOngoingEntity)) {
            dataValuesMap.put("personalDiv", orderDashboardOngoingEntity.getIsPersonal());
            dataValuesMap.put("type", orderDashboardOngoingEntity.getRowType());
        }
        if (Objects.nonNull(orderHeaderEntity.getOrderConfirmationDate())) {
            dataValuesMap.put(
                    "orderConfirmationDate",
                    HueDateTimeUtils.format(
                            orderHeaderEntity.getOrderConfirmationDate(),
                            HueDateTimeStyle.DATE_STANDARD_WITHOUT_YEAR_WITH_DAY_OF_THE_WEEK));
            dataValuesMap.put("confirmationDate", orderHeaderEntity.getOrderConfirmationDate());
        }
        return dataValuesMap;
    }

    @Override
    public void confirmOrder(OrderManagementEntity orderManagementEntity) {
        List<String> orderIdStringList = orderManagementEntity.getOrderIdDataList();
        updateOrderHeader(orderIdStringList);
        orderIdStringList.forEach(orderId -> {
            setOrderAvailabletoPromiseData(UUID.fromString(orderId));
            // setOrderDashboardData(UUID.fromString(orderId));
            // As instead of delteing and inserting in dashboard have updated row type and element type
            // in 19.01 fix updateRowTypeAndElementTypeOnGoingAfterStatusChangeOnHeader is used
                orderStatusControlService.updateRowTypeAndElementTypeOnGoingAfterStatusChangeOnHeader(
                        UUID.fromString(orderId),
                        OrderDashboardOngoingDtoRowType.WAITING_FOR_ATP_ANSWER.toString(),
                        OrderDashboardOngoingDtoElementType.WAITING_FOR_ATP_ANSWER_INPUT.toString());
            });
        insertOrderConfirmationAnswer(orderIdStringList);
    }

    /**
     * updateOrderHeader method is used to update the header details while confirm the order.
     *
     * @param orderIdStringList
     */
    private void updateOrderHeader(List<String> orderIdStringList) {
        List<OrderHeaderEntity> orderHeaderEntityRecordsList = orderHeaderDao.getMultiple(orderIdStringList);

        if (Objects.nonNull(orderHeaderEntityRecordsList)) {
            orderHeaderEntityRecordsList.stream()
                    .forEach(action -> {
                        if (Objects.isNull(action.getOrderConfirmationDate())) {
                            action.setOrderConfirmationDate(ZonedDateTime.now());
                        }
                        action.setOrderStatus(String.valueOf(OrderStatus.WAITING_FOR_ATP_ANSWER));
                        action.setOrderStatusName(MLString.of(textResourceManager.getText(TextId
                                .of(OrderStatus.WAITING_FOR_ATP_ANSWER.getValue()))));
                    });
            orderHeaderDao.insertMultiple(orderHeaderEntityRecordsList);
        }
    }

    /**
     * insertOrderConfirmationAnswer method is used to update the order_confirmation_answer dto.
     *
     * @param orderIdStringList
     */
    private void insertOrderConfirmationAnswer(List<String> orderIdStringList) {
        Set<String> orderStringSet = new HashSet<>();
        orderStringSet.addAll(orderIdStringList);
        List<OrderConfirmationAnswerEntity> orderConfirmationAnswerEntityList = orderStringSet
                .stream()
                .map(mapper -> {
                    OrderConfirmationAnswerEntity orderConfirmationAnswerEntity = orderConfirmationAnswerDao
                            .getFilterRecords(UUID.fromString(mapper));
                    if (Objects.nonNull(orderConfirmationAnswerEntity)) {
                        orderConfirmationAnswerEntity.setIsAnswered(OrderManagementConstant.NUMERIC_ONE);
                        orderConfirmationAnswerEntity.getConfirmationAnswerList()
                                .forEach(action -> action.setIsOk(OrderManagementConstant.NUMERIC_ONE));
                    }
                    return orderConfirmationAnswerEntity;
                }).collect(Collectors.toList());
        orderConfirmationAnswerDao.insertMultiple(orderConfirmationAnswerEntityList);
    }

    /**
     * insertContractDateForBarcode method is used to set the confirmation date
     *
     * @param orderStringId
     * @param zonedDateTime
     */
    private void insertContractDateForBarcode(String orderStringId, ZonedDateTime zonedDateTime) {
        UUID orderId = UUID.fromString(orderStringId);
        OrderHeaderEntity orderHeaderEntity = orderHeaderDao.getOrderHeaderEntity(orderId);
        List<OrderDetailEntity> orderDetailEntityList = orderDetailDao.getOrderDetails(orderId);
        orderHeaderEntity.setOrderConfirmationDate(zonedDateTime);
        orderHeaderEntity.setLastModified(LocalDate.now(TimeZoneHolder.getZoneId()));
        orderHeaderEntity.setLastupdateUserId(String.valueOf(scmUserContext.getUserId()));
        orderHeaderDao.insert(orderHeaderEntity);
        orderSearchRegisterService.register(orderId, orderHeaderEntity.getOrderStatus(), orderHeaderEntity,
                orderDetailEntityList, scmUserContext.getUserId());
        setOrderAvailabletoPromiseData(orderId);
        // setOrderDashboardData(orderId);
        // As instead of delteing and then inserting new status in dashboard have updated row type and element type
        // in 19.02 fix updateRowTypeAndElementTypeOnGoingAfterStatusChangeOnHeader is used

        orderStatusControlService.updateRowTypeAndElementTypeOnGoingAfterStatusChangeOnHeader(
                orderId,
                OrderDashboardOngoingDtoRowType.WAITING_FOR_ATP_ANSWER.toString(),
                OrderDashboardOngoingDtoElementType.WAITING_FOR_ATP_ANSWER_INPUT.toString());
    }

    @Override
    public String getOrderType(long corpId, PrintOrderSettingMstEntity printOrderSettingMstEntity) {
        return prPrintOrderSettingMstBaseDao.getOrderType(corpId, printOrderSettingMstEntity);
    }

    @Override
    public int setOrderType(PrintOrderSettingMstEntity printOrderSettingMstEntity) {
        return prPrintOrderSettingMstBaseDao.setOrderType(printOrderSettingMstEntity);
    }

    @Override
    @Transactional
    public Map<String, Object> printFormtypeSortedData(List<String> orderIdList) {
        Map<UUID, List<String>> dataMap = new LinkedHashMap<>();
        ListIterator<String> orderIdListIterator = orderIdList.listIterator();
        while (orderIdListIterator.hasNext()) {
            UUID orderId = convertToUUID(orderIdListIterator.next());
            if (Objects.nonNull(orderId)) {
                List<String> formTypeList = orderReportService.getFormTypes(orderId);
                dataMap.put(orderId, formTypeList);
            }
        }
        ReportSettingEntities reportSettingEntities = orderReportService
                .getFormtypeSortedReportEntities(dataMap);
        return reportSettingEntities.toZipFormattedMap();
    }

    /**
     * convertToUUID method is used to validate string before converting it to UUID
     *
     * @param orderId
     * @return UUID
     */
    public UUID convertToUUID(String orderId) {
        if (UUIDValidator.isUUID(orderId)) {
            return UUID.fromString(orderId);
        }
        return null;
    }

    @Override
    public Map<String, Object> printSortedData(List<String> orderIdList) {
        ReportSettingEntities externalEntities = orderIdList
                .stream()
                .map(this::convertToUUID)
                .map(orderId -> orderReportService.getSortedReportEntities(orderId, "external"))
                .filter(Objects::nonNull)
                .reduce(new ReportSettingEntities(), (firstEntity, secondEntity) -> firstEntity.merge(secondEntity),
                        (firstEntity, secondEntity) -> firstEntity.merge(secondEntity));
        ReportSettingEntities internalEntities = orderIdList
                .stream()
                .map(this::convertToUUID)
                .map(orderId -> orderReportService.getSortedReportEntities(orderId, "internal"))
                .filter(Objects::nonNull)
                .reduce(new ReportSettingEntities(), (firstEntity, secondEntity) -> firstEntity.merge(secondEntity),
                        (firstEntity, secondEntity) -> firstEntity.merge(secondEntity));
        ReportSettingEntities reportSettingEntities = externalEntities.merge(internalEntities);
        return reportSettingEntities.toZipFormattedMap();
    }

    @Override
    public Map<String, Object> loadPendingProvisionalOrderList(UserSegmentEnum userSegment, String type,
            int currentCount) {
        long corpId = scmUserContext.getActiveCorpId();
        List<ResponsibleOrderInboxVo> pendingOrderPendingList = getFilteredRecords(
                scmUserContext.getUserId().toString(), userSegment, type,
                corpId, OrderManagementConstant.APPLICATION,
                OrderManagementConstant.DESCENDING);
        session.put("totalRowCount", pendingOrderPendingList.size());
        return setPendingProvisionalOrderData(pendingOrderPendingList, currentCount);
    }

    @Override
    public Map<String, Object> getPersonDetails(UUID departmentInChargeId, String searchKey, boolean suggestFlag) {
        Map<String, Object> businessMap = new HashMap<>();
        List<Map<String, Object>> personInchargeMapList = new ArrayList<>();
        if (Objects.nonNull(departmentInChargeId)) {
            personInchargeMapList = comAcPersonInChargeDao
                    .loadQuotationPersonIncharge(
                            departmentInChargeId, LocalDate.now())
                    .stream()
                    .filter(filterPerson -> suggestFlag ? StringUtils.containsIgnoreCase(filterPerson
                            .getPersonInChargeName().get(), searchKey) : true)
                    .map(inCharge -> {
                        Map<String, Object> personInChargeMap = new HashMap<>();
                        personInChargeMap.put("personInChargeId", inCharge.getPersonInChargeId());
                        personInChargeMap.put("personInChargeName", inCharge.getPersonInChargeName().get());
                        return personInChargeMap;
                    }).collect(Collectors.toList());
        }
        businessMap.put("personInChargeMapList", personInchargeMapList);
        return businessMap;
    }

    @Override
    public Map<String, Object> getDepartmentDetails(UUID orderId, String orderType) {
        Map<String, Object> orderDepartmentInChargeMap = new HashMap<>();
        if (Objects.nonNull(orderId)) {
            if (StringUtils.equals(orderType, OrderManagementConstant.PROCUREMENT_REQUEST_TYPE)) {
                OrderPlanHeaderEntity orderPlanHeaderEntity = orderPlanHeaderDao.getSingle(orderId);
                orderDepartmentInChargeMap.put("departmentInChargeId", orderPlanHeaderEntity.getOrderDeptInChargeId());
                orderDepartmentInChargeMap
                        .put("departmentInChargeName", orderPlanHeaderEntity.getOrderDeptInChargeName().get());
            } else {
                OrderHeaderEntity orderHeaderEntity = orderHeaderDao.getOrderHeaderEntity(orderId);
                orderDepartmentInChargeMap.put("departmentInChargeId", orderHeaderEntity.getOrderDeptInChargeId());
                orderDepartmentInChargeMap
                        .put("departmentInChargeName", orderHeaderEntity.getOrderDeptInChargeName().get());
            }
        }
        return orderDepartmentInChargeMap;
    }

    @Override
    public void loadOrderAccepted(String orderStringId, String optionValue) {
        orderConfirmationService.confirm(orderStringId, optionValue);
    }
}
