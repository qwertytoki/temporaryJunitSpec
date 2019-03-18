package com.worksap.company.hue.scm.bizcore.procurement.enumerations.ordermanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderStatus {

    /**
     * TODO 依頼者事前見積中
     */
    PRE_ORDER_ON_QUOTATION("scm.pr.order.estimating.statuslabel.info"),

    /**
     * TODO 依頼者購入依頼申請中
     */
    PRE_ORDER_ON_PROCUREMENT_REQUEST("PC.POMT.pre_order_on_procurement_request"),

    /**
     * 発注依頼受付待ち
     */
    PRE_ORDER_ON_WAITING_FOR_ACCEPTANCE("scm.pr.order.estimating.orderwaiting.info"),

    /**
     * TODO 注文変更依頼受付待ち
     */
    PRE_ORDER_ON_WAITING_FOR_MODIFICATION("PC.POMT.pre_order_on_waiting_for_modification"),

    /**
     * 見積中
     */
    ORDERING_ON_QUOTATION("PC.POMT.ordering_on_quotation"),

    /**
     * 本見積中
     */
    QUOTING("PROC.POMT.quoting"),

    /**
     * 本見積取得完了
     */
    QUOTED("PROC.POMT.quoted"),

    /**
     * 一時保存
     */
    ORDERING_ON_TEMPORARY_SAVING("PC.POMT.temporarilySaved"),

    /**
     * 発注申請中
     */
    ORDERING_ON_REQUEST("PC.POMT.ordering"),

    /**
     * 発注申請差戻し
     */
    ORDERING_REMANDED("scm.pr.order.remanded.orderingremanded.info"),

    /**
     * TODO 発注申請取戻し
     */
    ORDERING_ON_WITHDREW("PC.POMT.ordering_on_withdrew"),

    /**
     * TODO 発注申請却下
     */
    ORDERING_REJECTED("PC.POMT.ordering_rejected"),

    /**
     * 注文書発行待ち
     */
    WAITING_FOR_ORDER_SHEET_PRINTING("scm.pr.order.neworder.waitingacceptance.info"),

    /**
     * 取消注文書発行待ち
     */
    WAITING_FOR_CANCEL_SHEET_PRINT("PC.POMT.waiting_for_cancel_sheet_print"),

    /**
     * 注文請け待ち
     */
    WAITING_FOR_CONFIRMATION("PC.POMT.orderPending"),

    /**
     * TODO 注文請け不可
     */
    ORDER_CONFIRMATION_DENIED("PC.POMT.order_confirmation_denied"),

    /**
     * 納期回答待ち
     */
    WAITING_FOR_ATP_ANSWER("PC.POMT.waitDelivery"),

    /**
     * TODO 出荷連絡待ち
     */
    WAITING_FOR_DISPATCH_NOTIFICATION("PC.POMT.waiting_for_dispatch_notification"),

    /**
     * 受入待ち
     */
    WAITING_FOR_RECEIVING("PC.POMT.awaitingAcceptance"),

    /**
     * 検収待ち
     */
    WAITING_FOR_INVOICE_ISSUING("PC.POMT.waiting_for_invoice_issuing"),

    /**
     * 検収済み
     */
    INVOICE_ISSUING_COMPLETED("PC.POMT.invoice_issuing_completed"),

    /**
     * 検収待ち
     */
    WAITING_FOR_ORDER_MATCHING("PC.POMT.awaitingOrderMatching"),

    /**
     * TODO 検収済み
     */
    ORDER_MATCHING_COMPLETED("PC.POMT.orderMatchingCompleted"),

    /**
     * TODO 注文変更伺い中
     */
    WAITING_FOR_MODIFICATION_CONFIRAMTION("PC.POMT.waiting_for_modification_confirmation"),

    /**
     * TODO 注文変更伺い不可
     */
    MODIFICATION_CONFIRMATION_DENIED("PC.POMT.modification_confirmation_denied"),

    /**
     * TODO 注文変更一時保存
     */
    MODIFICATION_ON_TEMPORARY_SAVING("PC.POMT.modifiedSaving"),

    /**
     * 注文変更申請中
     */
    MODIFICATION_ON_REQUEST("PC.POMT.modificationOrdering"),

    /**
     * 注文変更差戻し
     */
    MODIFICATION_REMANDED("PC.POMT.modificationRemanded"),

    /**
     * TODO 注文変更取戻し
     */
    MODIFICATION_ON_WITHDREW("PC.POMT.modification_on_withdrew"),

    /**
     * TODO 注文変更却下
     */
    MODIFICATION_REJECTED("PC.POMT.modification_rejected"),

    /**
     * 変更注文書発行待ち
     */
    WAITING_FOR_MODIFICATION_ORDER_SHEET_PRINTING("scm.pr.order.changeorder.waitingmodification.info"),

    /**
     * TODO 仮発注確定待ち
     */
    WAITING_FOR_PROVISIONAL_ORDER_COMMITION("PC.POMT.waiting_for_provisional_order_commition"),

    /**
     * 社内取消済み
     */
    INTERNAL_CANCELED("PC.POMT.internal_canceled"),

    /**
     * 取消注文書発行待ち
     */
    WAITING_FOR_CANCEL_ORDER_SHEET_PRINTING("PC.POMT.cancelSheetPrinting"),

    /**
     * 取消申請中
     */
    CANCEL_ON_REQUEST("PC.POMT.cancelRequest"),

    /**
     * 取消申請差戻し
     */
    CANCELLATION_REMANDED("PC.POMT.cancelRemanded"),

    /**
     * 取消済み
     */
    CANCELED("PC.POMT.canceled"),

    /**
     * 取消申請一時保存
     */
    CANCEL_ON_TEMPORARY_SAVING("PC.POMT.cancel_on_temporary_saving"),

    /**
     * 取消申請取戻し
     */
    CANCEL_ON_WITHDREW("PC.POMT.cancel_on_withdrew"),

    /**
     * 取消申請却下
     */
    CANCEL_REJECTED("PC.POMT.cancel_rejected"),

    /**
     * 変更伺い中
     */
    CANCEL_FOR_MODIFICATION_CONFIRAMTION("PC.POMT.cancel_for_modification_confirmation"),

    /**
     * 出来高報告待ち
     */
    WAITING_FOR_PROGRESS_BASED_INSPECTION("PC.POMT.waitForProgressBasedInspection"),

    /**
     * 出来高報告中
     */
    PROGRESS_BASED_INSPECTING("PC.POMT.progressBasedInspecting"),

    /**
     * 社内変更申請中
     */
    INNER_MODIFICATION("PROC.POMT.innerModification"),

    /**
     * 完工済
     */
    CONSTRUCTION_COMPLETED("PROC.POMT.constructionCompleted"),

    NONE("");

    /**
     * Gets the value.
     *
     * @return the value
     */
    @Getter
    private final String value;

}
