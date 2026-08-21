<jsp:directive.include file="/pages/common/include.jsp" />
<jsp:directive.page import="com.mars.common.utils.Constants" />
<jsp:directive.page import="com.mars.common.utils.CommonUtils" />

<%@ page import="java.util.Arrays" %>
<%!
    /* Format a numeric amount in INDIAN grouping (lakh/crore), ROUNDED to the whole rupee (HALF_UP), no paise.
       e.g. 6432.50 -> 6,433 ; 25284894.70 -> 2,52,84,895 ; 1456789 -> 14,56,789 ; null/blank -> "".
       Java's DecimalFormat can't do Indian grouping via a pattern, so we group manually. */
    private static String fmtIndianAmount(Object raw) {
        if (raw == null) return "";
        String s = String.valueOf(raw).replace(",", "").trim();
        if (s.isEmpty()) return "";
        try {
            java.math.BigDecimal bd = new java.math.BigDecimal(s)
                    .setScale(0, java.math.RoundingMode.HALF_UP);  // round off to whole rupee, drop paise
            boolean neg = bd.signum() < 0;
            String intPart = bd.abs().toPlainString();             // e.g. "6433"
            String grouped;
            if (intPart.length() <= 3) {
                grouped = intPart;
            } else {
                String last3 = intPart.substring(intPart.length() - 3);
                String rest  = intPart.substring(0, intPart.length() - 3);
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int i = rest.length() - 1; i >= 0; i--) {
                    sb.append(rest.charAt(i));
                    if (++count % 2 == 0 && i != 0) sb.append(',');
                }
                grouped = sb.reverse().toString() + "," + last3;
            }
            return (neg ? "-" : "") + grouped;
        } catch (NumberFormatException e) {
            return String.valueOf(raw);
        }
    }
%>


<%
pageContext.setAttribute("DATE_FORMAT", Constants.DATE_FORMAT);
pageContext.setAttribute("SESSION_TOKEN_KEY", Constants.SESSION_TOKEN_KEY);
pageContext.setAttribute("STATUS_NO_LABEL", Constants.STATUS_NO_LABEL);
pageContext.setAttribute("STATUS_YES_LABEL", Constants.STATUS_YES_LABEL);
pageContext.setAttribute("STATUS_NO", Constants.STATUS_NO);
pageContext.setAttribute("STATUS_YES", Constants.STATUS_YES);
%>

<style type="text/css">
/* Scope everything to #SetFormHeight so this page's styling can't be
   silently overridden by global button/table/panel rules coming from
   /pages/common/include.jsp (that was the cause of the accordion header
   and buttons rendering as plain unstyled text/links). */

#SetFormHeight, #SetFormHeight * {
    box-sizing: border-box;
}

#SetFormHeight {
    --navy-900: #0b2540;
    --navy-800: #123a5e;
    --navy-700: #1c4d76;
    --blue-600: #1f6fb2;
    --blue-100: #eaf3fb;
    --gold-600: #b8801f;
    --gold-100: #faf1de;
    --green-600: #2f7d5a;
    --green-100: #e7f5ee;
    --purple-600: #6f4fb0;
    --purple-100: #f0ebfa;
    --orange-600: #c96a1f;
    --orange-100: #fbeee0;
    --slate-900: #1f2d3d;
    --slate-600: #5b6b7c;
    --slate-400: #8695a6;
    --slate-200: #e3e9ef;
    --bg: #f2f5f9;
    --card-bg: #ffffff;
}

html, body {
    max-width: 100%;
}

/* ---------- Main Page Container ---------- */
#SetFormHeight.page-container {
    display: block;
    width: 1px;          /* forces shrink-to-parent instead of growing to content */
    min-width: 100%;     /* then re-expands to fill whatever width the parent actually gives */
    max-width: 100%;
    overflow-x: hidden;
    padding: 16px !important;
    background: var(--bg) !important;
    font-family: "Segoe UI", "Helvetica Neue", Arial, sans-serif !important;
    color: var(--slate-900) !important;
}

/* ---------- Header ---------- */
#SetFormHeight .fire-header {
    position: relative;
    width: 100%;
    max-width: 100%;
    min-width: 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
    gap: 16px;
    flex-wrap: wrap;
    margin-bottom: 20px;
    padding: 24px 28px !important;
    background: linear-gradient(120deg, var(--navy-900) 0%, var(--navy-700) 100%) !important;
    border-radius: 12px !important;
    overflow: hidden;
    box-shadow: 0 8px 24px rgba(11, 37, 64, 0.18) !important;
}

#SetFormHeight .fire-header::after {
    content: "";
    position: absolute;
    left: 0;
    right: 0;
    bottom: 0;
    height: 4px;
    background: linear-gradient(90deg, var(--gold-600), transparent 70%);
}

#SetFormHeight .fire-header-left {
    flex: 1 1 auto;
    min-width: 0;
}

#SetFormHeight .fire-header-left .eyebrow {
    display: inline-block;
    text-transform: uppercase;
    letter-spacing: 1.5px;
    font-size: 11px;
    font-weight: 700;
    color: #ffce85;
    margin-bottom: 6px;
}

#SetFormHeight .fire-header-left h2 {
    margin: 0;
    color: #ffffff !important;
    font-size: 24px;
    font-weight: 700;
    letter-spacing: 0.2px;
}

#SetFormHeight .fire-header-left p {
    margin: 6px 0 0;
    color: #b9cbdd;
    font-size: 13px;
}

#SetFormHeight .fire-total-box {
    position: relative;
    flex: 0 0 auto;
    min-width: 180px;
    background: rgba(255, 255, 255, 0.08);
    border: 1px solid rgba(255, 255, 255, 0.18);
    border-radius: 10px;
    padding: 14px 26px;
    text-align: center;
    backdrop-filter: blur(2px);
}

#SetFormHeight .fire-total-box .label {
    display: block;
    font-size: 11px;
    text-transform: uppercase;
    letter-spacing: 1px;
    color: #b9cbdd;
    margin-bottom: 6px;
}

#SetFormHeight .fire-total-box .value {
    font-size: 30px;
    font-weight: 800;
    color: #ffffff;
}

/* ---------- Summary Cards ---------- */
#SetFormHeight .summary-grid {
    width: 100%;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(190px, 1fr));
    gap: 14px;
    margin-bottom: 18px;
}

#SetFormHeight .summary-card {
    position: relative;
    width: 100%;
    min-width: 0;
    max-width: 100%;
    background: var(--card-bg) !important;
    border: 1px solid var(--slate-200) !important;
    border-left: 4px solid var(--slate-400) !important;
    border-radius: 10px !important;
    padding: 16px 16px 14px !important;
    box-shadow: 0 2px 8px rgba(15, 35, 60, 0.05) !important;
    cursor: pointer;
    transition: transform 0.15s ease, box-shadow 0.15s ease, border-color 0.15s ease;
}

#SetFormHeight .summary-card:hover,
#SetFormHeight .summary-card:focus-visible {
    transform: translateY(-3px);
    box-shadow: 0 10px 22px rgba(15, 35, 60, 0.12) !important;
}

#SetFormHeight .summary-card:focus-visible {
    outline: 2px solid var(--blue-600);
    outline-offset: 2px;
}

#SetFormHeight .summary-card.card-total     { border-left-color: var(--blue-600) !important; }
#SetFormHeight .summary-card.card-citizen   { border-left-color: var(--green-600) !important; }
#SetFormHeight .summary-card.card-forwarded { border-left-color: var(--orange-600) !important; }
#SetFormHeight .summary-card.card-l1        { border-left-color: var(--purple-600) !important; }
#SetFormHeight .summary-card.card-completed { border-left-color: var(--gold-600) !important; }

#SetFormHeight .summary-card .icon-badge {
    width: 34px;
    height: 34px;
    border-radius: 8px;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-bottom: 10px;
    flex-shrink: 0;
}

#SetFormHeight .card-total .icon-badge     { background: var(--blue-100); }
#SetFormHeight .card-citizen .icon-badge   { background: var(--green-100); }
#SetFormHeight .card-forwarded .icon-badge { background: var(--orange-100); }
#SetFormHeight .card-l1 .icon-badge        { background: var(--purple-100); }
#SetFormHeight .card-completed .icon-badge { background: var(--gold-100); }

#SetFormHeight .summary-card .icon-badge svg { width: 18px; height: 18px; }

#SetFormHeight .summary-card .title {
    font-size: 12.5px;
    font-weight: 600;
    color: var(--slate-600);
    margin-bottom: 6px;
    letter-spacing: 0.2px;
    min-height: 32px;
    overflow-wrap: anywhere;
    word-break: break-word;
}

#SetFormHeight .summary-card .count {
    font-size: 26px;
    font-weight: 800;
    color: var(--navy-900);
    line-height: 1;
}

#SetFormHeight .summary-card .jump-link {
    display: inline-flex;
    align-items: center;
    gap: 4px;
    margin-top: 12px;
    color: var(--blue-600);
    text-decoration: none;
    font-size: 12.5px;
    font-weight: 700;
}

#SetFormHeight .summary-card .jump-link:hover {
    text-decoration: underline;
}

/* ---------- Quick links ---------- */
#SetFormHeight .quick-links {
    margin-bottom: 18px;
    display: flex;
    gap: 10px;
    flex-wrap: wrap;
}

#SetFormHeight .quick-links button {
    all: revert;
    font: inherit !important;
    display: inline-flex;
    align-items: center;
    gap: 6px;
    padding: 8px 16px !important;
    background: #ffffff !important;
    border: 1px solid var(--slate-200) !important;
    border-radius: 20px !important;
    cursor: pointer;
    color: var(--navy-800) !important;
    font-size: 13px !important;
    font-weight: 600 !important;
    transition: background 0.15s ease, border-color 0.15s ease, color 0.15s ease;
}

#SetFormHeight .quick-links button:hover {
    background: var(--navy-900) !important;
    border-color: var(--navy-900) !important;
    color: #ffffff !important;
}

/* ---------- Section panels (accordion) ---------- */
#SetFormHeight .section-panel {
    scroll-margin-top: 16px;
    margin-bottom: 16px;
    border: 1px solid var(--slate-200) !important;
    border-radius: 10px !important;
    overflow: hidden;
    background: var(--card-bg) !important;
    box-shadow: 0 1px 3px rgba(15, 35, 60, 0.04) !important;
}

#SetFormHeight .section-toggle {
    all: revert;
    width: 100%;
    border: none !important;
    outline: none;
    cursor: pointer;
    text-align: left;
    padding: 16px 18px !important;
    background: #f7fafd !important;
    color: var(--navy-900) !important;
    font-size: 15px !important;
    font-weight: 700 !important;
    font-family: inherit !important;
    display: flex;
    justify-content: space-between;
    align-items: center;
    gap: 10px;
    transition: background 0.15s ease;
}

#SetFormHeight .section-toggle:hover {
    background: var(--blue-100) !important;
}

#SetFormHeight .section-toggle.active {
    background: var(--blue-100) !important;
    border-bottom: 1px solid var(--slate-200) !important;
}

#SetFormHeight .section-toggle .section-title-wrap {
    display: flex;
    align-items: center;
    gap: 10px;
    flex-wrap: wrap;
    min-width: 0;
}

#SetFormHeight .section-count-badge {
    display: inline-block;
    padding: 3px 11px !important;
    border-radius: 20px !important;
    background: var(--navy-800) !important;
    color: #fff !important;
    font-size: 12px;
    font-weight: 700;
}

#SetFormHeight .section-toggle .arrow {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    width: 24px;
    height: 24px;
    font-size: 16px;
    font-weight: bold;
    color: var(--navy-800);
    transition: transform 0.2s ease;
    flex-shrink: 0;
}

#SetFormHeight .section-toggle.active .arrow {
    transform: rotate(180deg);
}

#SetFormHeight .section-content {
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.28s ease-out;
    background: #ffffff;
}

#SetFormHeight .section-inner {
    padding: 16px;
}

/* ---------- Section toolbar (Search / Export / Print) ---------- */
#SetFormHeight .section-toolbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    gap: 10px;
    margin-bottom: 10px;
    flex-wrap: wrap;
}

#SetFormHeight .table-search {
    flex: 1 1 260px;
    min-width: 200px;
    max-width: 360px;
}

#SetFormHeight .search-input {
    all: revert;
    width: 100%;
    font: inherit !important;
    font-size: 13px !important;
    padding: 8px 12px !important;
    border: 1px solid var(--slate-200) !important;
    border-radius: 6px !important;
    background: #ffffff !important;
    color: var(--slate-900) !important;
}

#SetFormHeight .search-input:focus {
    outline: none;
    border-color: var(--blue-600) !important;
    box-shadow: 0 0 0 2px rgba(31, 111, 178, 0.15);
}

#SetFormHeight .toolbar-actions {
    display: flex;
    gap: 8px;
    flex-wrap: wrap;
}

#SetFormHeight .toolbar-btn {
    all: revert;
    display: inline-flex;
    align-items: center;
    gap: 6px;
    font: inherit !important;
    font-size: 12.5px !important;
    font-weight: 600 !important;
    padding: 7px 13px !important;
    border-radius: 6px !important;
    border: 1px solid var(--slate-200) !important;
    background: #ffffff !important;
    color: var(--navy-800) !important;
    cursor: pointer;
    transition: background 0.15s ease, color 0.15s ease, border-color 0.15s ease;
}

#SetFormHeight .toolbar-btn svg {
    width: 14px;
    height: 14px;
    flex-shrink: 0;
}

#SetFormHeight .toolbar-btn.export-btn:hover {
    background: var(--green-600) !important;
    border-color: var(--green-600) !important;
    color: #ffffff !important;
}

#SetFormHeight .toolbar-btn.print-btn:hover {
    background: var(--navy-900) !important;
    border-color: var(--navy-900) !important;
    color: #ffffff !important;
}

#SetFormHeight .table-wrapper {
    width: 100%;
    max-width: 100%;
    overflow-x: auto;
    border: 1px solid var(--slate-200) !important;
    border-radius: 8px !important;
}

#SetFormHeight .dataGrid {
    width: 100%;
    min-width: 1100px;
    border-collapse: collapse !important;
}

#SetFormHeight .dataGrid thead td {
    background: var(--navy-900) !important;
    color: #eaf1f8 !important;
    font-weight: 600 !important;
    font-size: 12.5px;
    text-transform: uppercase;
    letter-spacing: 0.4px;
    padding: 11px 10px !important;
    white-space: nowrap;
    position: sticky;
    top: 0;
}

#SetFormHeight .dataGrid thead td.sr-no-col {
    width: 56px;
    text-align: center;
}

#SetFormHeight .dataGrid tbody td.sr-no-col {
    text-align: center;
    color: var(--slate-600);
    font-weight: 600;
}

#SetFormHeight .dataGrid tbody td {
    padding: 10px 10px !important;
    border-bottom: 1px solid #eef2f6 !important;
    vertical-align: top;
    font-size: 13.5px;
    color: var(--slate-900);
}

#SetFormHeight .dataGrid tbody tr:nth-child(even) {
    background: #fafcff;
}

#SetFormHeight .dataGrid tbody tr:hover {
    background: var(--blue-100);
}

#SetFormHeight .status-badge {
    display: inline-block;
    padding: 5px 11px !important;
    border-radius: 16px !important;
    font-size: 11.5px;
    font-weight: 700;
    line-height: 1.4;
    background: #eef3f8 !important;
    color: #2f4356 !important;
    white-space: nowrap;
}

#SetFormHeight .category-badge {
    display: inline-block;
    padding: 5px 11px !important;
    border-radius: 16px !important;
    font-size: 11.5px;
    font-weight: 700;
    line-height: 1.4;
    color: #ffffff !important;
}

#SetFormHeight .category-citizen   { background: var(--green-600) !important; }
#SetFormHeight .category-l1        { background: var(--purple-600) !important; }
#SetFormHeight .category-forwarded { background: var(--orange-600) !important; }

#SetFormHeight .empty-records {
    padding: 22px;
    text-align: center;
    color: var(--slate-400);
    font-weight: 600;
}

/* ---------- Pagination ---------- */
#SetFormHeight .pagination-bar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 10px;
    margin-top: 12px;
    padding-top: 12px;
    border-top: 1px solid var(--slate-200) !important;
}

#SetFormHeight .pagination-info {
    font-size: 12.5px;
    color: var(--slate-600);
    font-weight: 600;
}

#SetFormHeight .pagination-nav {
    display: flex;
    align-items: center;
    gap: 4px;
    flex-wrap: wrap;
}

#SetFormHeight .pagination-nav button {
    all: revert;
    font: inherit !important;
    min-width: 30px;
    padding: 6px 10px !important;
    border: 1px solid var(--slate-200) !important;
    background: #ffffff !important;
    color: var(--navy-800) !important;
    border-radius: 6px !important;
    font-size: 12.5px !important;
    font-weight: 600 !important;
    cursor: pointer;
    transition: background 0.15s ease, color 0.15s ease;
}

#SetFormHeight .pagination-nav button:hover:not(:disabled) {
    background: var(--blue-100) !important;
}

#SetFormHeight .pagination-nav button.active-page {
    background: var(--navy-900) !important;
    border-color: var(--navy-900) !important;
    color: #ffffff !important;
}

#SetFormHeight .pagination-nav button:disabled {
    opacity: 0.4;
    cursor: not-allowed;
}

@media screen and (max-width: 767px) {
    #SetFormHeight .fire-header {
        flex-direction: column;
        align-items: flex-start;
    }

    #SetFormHeight .fire-total-box {
        width: 100%;
    }

    #SetFormHeight .summary-grid {
        grid-template-columns: 1fr;
    }

    #SetFormHeight .section-toggle {
        font-size: 14px !important;
    }

    #SetFormHeight .section-toolbar {
        justify-content: flex-start;
    }

    #SetFormHeight .table-search {
        max-width: none;
        flex-basis: 100%;
    }
}
</style>

<script type="text/javascript">
function editRTIApplication(refId, id) {
    document.getElementById('rtiApplicationRefId').value = refId;
    document.getElementById('rtiApplicationId').value = id;
    onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/editFireRecommendation.do');
}

function searchRTIApplication() {
    onPageSubmit('<c:out value="${contextRoot}"/>/rtsapplication/listRTSFireRecommendation.do');
}

/* Collapse every panel back to its closed state */
function closeAllSections() {
    var buttons = document.getElementsByClassName("section-toggle");
    for (var i = 0; i < buttons.length; i++) {
        var button = buttons[i];
        var content = button.nextElementSibling;
        button.classList.remove("active");
        content.style.maxHeight = null;
    }
}

/* Manual toggle from clicking a section header directly */
function toggleSection(button) {
    var content = button.nextElementSibling;
    var isOpen = button.classList.contains("active");

    if (isOpen) {
        button.classList.remove("active");
        content.style.maxHeight = null;
    } else {
        closeAllSections();
        button.classList.add("active");
        content.style.maxHeight = content.scrollHeight + "px";
    }
}

/* Open a specific section (used by summary cards / quick links), closing the rest,
   then scroll it into view so the user lands straight on the relevant list. */
function openSection(sectionId) {
    var panel = document.getElementById(sectionId);
    if (!panel) return;

    closeAllSections();

    var button = panel.querySelector(".section-toggle");
    var content = panel.querySelector(".section-content");
    if (button && content) {
        button.classList.add("active");
        content.style.maxHeight = content.scrollHeight + "px";
    }

    setTimeout(function () {
        panel.scrollIntoView({ behavior: "smooth", block: "start" });
    }, 80);
}

/* Recalculate the open section's max-height whenever its inner content
   changes size (pagination, search filtering, window resize). */
function refreshOpenSectionHeight(withinElement) {
    var content = withinElement && withinElement.closest ? withinElement.closest(".section-content") : null;
    if (!content) return;
    var button = content.previousElementSibling;
    if (button && button.classList.contains("active")) {
        content.style.maxHeight = content.scrollHeight + "px";
    }
}

window.addEventListener("resize", function () {
    var activeButton = document.querySelector(".section-toggle.active");
    if (activeButton) {
        refreshOpenSectionHeight(activeButton.nextElementSibling);
    }
});

/* ---------- Export current table to Excel (.xls) ---------- */
function exportTableToExcel(tableId, filename) {
    var table = document.getElementById(tableId);
    if (!table) return;

    var clone = table.cloneNode(true);
    var rows = clone.querySelectorAll("tbody tr");
    for (var i = 0; i < rows.length; i++) {
        rows[i].style.display = "";
    }

    var htmlContent =
        '<html xmlns:o="urn:schemas-microsoft-com:office:office" ' +
        'xmlns:x="urn:schemas-microsoft-com:office:excel" ' +
        'xmlns="http://www.w3.org/TR/REC-html40">' +
        '<head><meta charset="UTF-8"></head><body>' +
        clone.outerHTML +
        '</body></html>';

    var blob = new Blob(["\ufeff", htmlContent], { type: "application/vnd.ms-excel" });
    var link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    link.download = (filename || "export") + ".xls";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    URL.revokeObjectURL(link.href);
}

/* ---------- Print just one table ---------- */
function printTable(tableId, titleText) {
    var table = document.getElementById(tableId);
    if (!table) return;

    var clone = table.cloneNode(true);
    var rows = clone.querySelectorAll("tbody tr");
    for (var i = 0; i < rows.length; i++) {
        rows[i].style.display = "";
    }

    var printWindow = window.open("", "_blank", "width=1200,height=800");
    if (!printWindow) return;

    printWindow.document.write("<html><head><title>" + titleText + "</title>");
    printWindow.document.write(
        "<style>" +
        "body{font-family:Arial, Helvetica, sans-serif;padding:20px;color:#1f2d3d;}" +
        "h2{color:#0b2540;margin-bottom:14px;}" +
        "table{border-collapse:collapse;width:100%;font-size:11.5px;}" +
        "th,td{border:1px solid #ccc;padding:6px 8px;text-align:left;}" +
        "thead td{background:#0b2540;color:#fff;font-weight:bold;}" +
        ".status-badge,.category-badge{padding:2px 7px;border-radius:10px;background:#eef3f8;display:inline-block;}" +
        "@media print { body { padding: 0; } }" +
        "</style></head><body>"
    );
    printWindow.document.write("<h2>" + titleText + "</h2>");
    printWindow.document.write(clone.outerHTML);
    printWindow.document.write("</body></html>");
    printWindow.document.close();
    printWindow.focus();

    setTimeout(function () {
        printWindow.print();
        printWindow.close();
    }, 300);
}

/* ---------- Client-side pagination + search for the data tables ----------
   Each dataGrid's FULL row set is rendered by the server (see the
   controller fix). This script keeps that full row set in memory per
   table, applies an optional text filter, and only ever displays one
   "page" of the (possibly filtered) rows at a time so the pagination
   count and the summary-card count always agree. */
var tablePaginationState = {};

function initTablePagination(pageSize) {
    pageSize = pageSize || 10;
    var tables = document.querySelectorAll(".dataGrid");

    tables.forEach(function (table) {
        var tbody = table.querySelector("tbody");
        if (!tbody) return;

        var allRows = Array.prototype.slice.call(tbody.querySelectorAll("tr"));
        if (allRows.length === 0) return;
        if (allRows.length === 1 && allRows[0].querySelector(".empty-records")) return;

        var wrapper = table.closest(".table-wrapper");
        if (!wrapper) return;

        var pager = document.createElement("div");
        pager.className = "pagination-bar";
        wrapper.parentNode.insertBefore(pager, wrapper.nextSibling);

        tablePaginationState[table.id] = {
            allRows: allRows,
            filteredRows: allRows.slice(),
            pageSize: pageSize,
            currentPage: 1,
            pager: pager,
            wrapper: wrapper
        };

        renderTablePage(table.id, 1);
    });
}

function renderTablePage(tableId, page) {
    var state = tablePaginationState[tableId];
    if (!state) return;

    var rows = state.filteredRows;
    var pageSize = state.pageSize;
    var totalPages = Math.max(1, Math.ceil(rows.length / pageSize));
    page = Math.min(Math.max(1, page), totalPages);
    state.currentPage = page;

    state.allRows.forEach(function (row) { row.style.display = "none"; });

    var startIdx = (page - 1) * pageSize;
    rows.slice(startIdx, startIdx + pageSize).forEach(function (row) {
        row.style.display = "";
    });

    renderPaginationControls(tableId, page, totalPages, rows.length);
    refreshOpenSectionHeight(state.wrapper);
}

function renderPaginationControls(tableId, currentPage, totalPages, totalRecords) {
    var state = tablePaginationState[tableId];
    var pager = state.pager;
    pager.innerHTML = "";

    var info = document.createElement("span");
    info.className = "pagination-info";

    if (totalRecords === 0) {
        info.textContent = "No matching records found";
        pager.appendChild(info);
        return;
    }

    var startRec = (currentPage - 1) * state.pageSize + 1;
    var endRec = Math.min(currentPage * state.pageSize, totalRecords);
    info.textContent = "Showing " + startRec + "\u2013" + endRec + " of " + totalRecords + " records";
    pager.appendChild(info);

    if (totalPages <= 1) return;

    var nav = document.createElement("div");
    nav.className = "pagination-nav";

    var prevBtn = document.createElement("button");
    prevBtn.type = "button";
    prevBtn.textContent = "Prev";
    prevBtn.disabled = currentPage === 1;
    prevBtn.onclick = function () { renderTablePage(tableId, currentPage - 1); };
    nav.appendChild(prevBtn);

    var maxButtons = 5;
    var startP = Math.max(1, currentPage - 2);
    var endP = Math.min(totalPages, startP + maxButtons - 1);
    startP = Math.max(1, endP - maxButtons + 1);

    for (var p = startP; p <= endP; p++) {
        (function (pageNum) {
            var btn = document.createElement("button");
            btn.type = "button";
            btn.textContent = pageNum;
            if (pageNum === currentPage) btn.className = "active-page";
            btn.onclick = function () { renderTablePage(tableId, pageNum); };
            nav.appendChild(btn);
        })(p);
    }

    var nextBtn = document.createElement("button");
    nextBtn.type = "button";
    nextBtn.textContent = "Next";
    nextBtn.disabled = currentPage === totalPages;
    nextBtn.onclick = function () { renderTablePage(tableId, currentPage + 1); };
    nav.appendChild(nextBtn);

    pager.appendChild(nav);
}

/* Called from each section's search input (oninput). Filters by matching
   the typed text against the visible text of the whole row (application
   no., applicant name, status, zone, etc. all get matched). */
function filterTable(tableId, query) {
    var state = tablePaginationState[tableId];
    if (!state) return;

    query = (query || "").trim().toLowerCase();

    state.filteredRows = !query
        ? state.allRows.slice()
        : state.allRows.filter(function (row) {
            return row.textContent.toLowerCase().indexOf(query) !== -1;
        });

    renderTablePage(tableId, 1);
}

window.addEventListener("DOMContentLoaded", function () {
    initTablePagination(10);
});
</script>

<div class="page-container" id="SetFormHeight">

    <div class="fire-header">
        <div class="fire-header-left">
            <span class="eyebrow">Fire Department &middot; RTS Dashboard</span>
            <h2><c:out value="${requestScope.pageTitle}" /></h2>
            <p>Overview of all fire service applications and their current stage</p>
        </div>

        <div class="fire-total-box">
            <span class="label">Total Records</span>
            <span class="value"><c:out value="${requestScope.totalCount}" /></span>
        </div>
    </div>

    <div class="summary-grid">
        <div class="summary-card card-total" tabindex="0" role="button"
             onclick="openSection('totalSection')"
             onkeypress="if(event.key==='Enter'){openSection('totalSection')}">
            <div class="icon-badge">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <rect x="4" y="3" width="16" height="18" rx="2" stroke="#1f6fb2" stroke-width="1.8"/>
                    <path d="M8 8h8M8 12h8M8 16h5" stroke="#1f6fb2" stroke-width="1.8" stroke-linecap="round"/>
                </svg>
            </div>
            <div class="title">Total Applications</div>
            <div class="count"><c:out value="${requestScope.totalCount}" /></div>
            <span class="jump-link">View list &rarr;</span>
        </div>

        <div class="summary-card card-citizen" tabindex="0" role="button"
             onclick="openSection('citizenSection')"
             onkeypress="if(event.key==='Enter'){openSection('citizenSection')}">
            <div class="icon-badge">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M4 8l8 5 8-5" stroke="#2f7d5a" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                    <rect x="4" y="6" width="16" height="12" rx="2" stroke="#2f7d5a" stroke-width="1.8"/>
                </svg>
            </div>
            <div class="title">Applications Received</div>
            <div class="count"><c:out value="${requestScope.citizenCount}" /></div>
            <span class="jump-link">View list &rarr;</span>
        </div>

        <div class="summary-card card-forwarded" tabindex="0" role="button"
             onclick="openSection('forwardedSection')"
             onkeypress="if(event.key==='Enter'){openSection('forwardedSection')}">
            <div class="icon-badge">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M5 12h13M13 6l6 6-6 6" stroke="#c96a1f" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                </svg>
            </div>
            <div class="title">Applications Forwarded</div>
            <div class="count"><c:out value="${requestScope.forwardedCount}" /></div>
            <span class="jump-link">View list &rarr;</span>
        </div>

        <div class="summary-card card-l1" tabindex="0" role="button"
             onclick="openSection('l1Section')"
             onkeypress="if(event.key==='Enter'){openSection('l1Section')}">
            <div class="icon-badge">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <rect x="4" y="10" width="6" height="10" stroke="#6f4fb0" stroke-width="1.8"/>
                    <rect x="14" y="4" width="6" height="16" stroke="#6f4fb0" stroke-width="1.8"/>
                </svg>
            </div>
            <div class="title">Applications Received From L1</div>
            <div class="count"><c:out value="${requestScope.l1Count}" /></div>
            <span class="jump-link">View list &rarr;</span>
        </div>

        <div class="summary-card card-completed" tabindex="0" role="button"
             onclick="openSection('completedSection')"
             onkeypress="if(event.key==='Enter'){openSection('completedSection')}">
            <div class="icon-badge">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <circle cx="12" cy="12" r="8" stroke="#b8801f" stroke-width="1.8"/>
                    <path d="M8.5 12.2l2.4 2.4 4.6-5.2" stroke="#b8801f" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                </svg>
            </div>
            <div class="title">Applications Completed</div>
            <div class="count"><c:out value="${requestScope.completedCount}" /></div>
            <span class="jump-link">View list &rarr;</span>
        </div>
    </div>

    <div class="quick-links">
        <button type="button" onclick="openSection('totalSection')">Total</button>
        <button type="button" onclick="openSection('citizenSection')">Citizen</button>
        <button type="button" onclick="openSection('forwardedSection')">Forwarded</button>
        <button type="button" onclick="openSection('l1Section')">L1 Level</button>
        <button type="button" onclick="openSection('completedSection')">Completed</button>
    </div>

    <!-- Total application section -->
    <div class="section-panel" id="totalSection">
        <button type="button" class="section-toggle" onclick="toggleSection(this)">
            <span class="section-title-wrap">
                <span>Total Applications</span>
                <span class="section-count-badge"><c:out value="${requestScope.totalCount}" /></span>
            </span>
            <span class="arrow">&#9660;</span>
        </button>

        <div class="section-content">
            <div class="section-inner">
                <div class="section-toolbar">
                    <div class="table-search">
                        <input type="text" class="search-input" id="totalSearchInput"
                               placeholder="Search application no., name..."
                               oninput="filterTable('totalTable', this.value)" />
                    </div>
                    <div class="toolbar-actions">
                        <button type="button" class="toolbar-btn export-btn"
                                onclick="exportTableToExcel('totalTable','Total_Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 3v12m0 0l-4-4m4 4l4-4" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M5 17v2a2 2 0 002 2h10a2 2 0 002-2v-2" stroke="currentColor" stroke-width="1.8" stroke-linecap="round"/>
                            </svg>
                            Export to Excel
                        </button>
                        <button type="button" class="toolbar-btn print-btn"
                                onclick="printTable('totalTable','Total Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M6 9V3h12v6M6 18h12v4H6v-4zM4 9h16a1 1 0 011 1v6a1 1 0 01-1 1h-3v3H7v-3H4a1 1 0 01-1-1v-6a1 1 0 011-1z" stroke="currentColor" stroke-width="1.5" stroke-linejoin="round"/>
                            </svg>
                            Print
                        </button>
                    </div>
                </div>
                <div class="table-wrapper">
                    <table cellpadding="0" cellspacing="1" class="dataGrid" id="totalTable">
                        <thead>
                            <tr>
                                <td class="sr-no-col">Sr. No.</td>
                                <td>Application No.</td>
                                <td>Registration Date</td>
                                <td>Applicant Name</td>
                                <td>Scrutiny Fee</td>
                                <td>Scrutiny Transaction ID</td>
                                <td>Demand Fee Status</td>
                                <td>Demand Transaction ID</td>
                                <td>Application Status</td>
                                <td>Current Zone</td>
                                <td>Category</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty totalList}">
                                <c:forEach var="item" items="${totalList}" varStatus="totalStatus">
                                    <tr>
                                        <td class="sr-no-col"><c:out value="${totalStatus.index + 1}"/></td>

                                        <td>
                                            <c:choose>
                                                <c:when test="${requestScope.forLogin eq 'L2'}">
                                                    <c:out value="${item.application.rtiApplnNumber}"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <a title="<fmt:message key="list.link.EditOrViewLink"/>"
                                                       href="javascript:editRTIApplication('${item.application.rtiApplicationRefId}','${item.application.rtiApplicationId}');">
                                                        <c:out value="${item.application.rtiApplnNumber}" />
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>

                                        <td><c:out value="${item.application.registrationDate}"/></td>
                                        <td><c:out value="${item.application.applicantName}"/></td>

                                        <td>
                                            <c:set var="rawAmt" value="${item.application.firstPaymentFees}"/>
                                            <%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %>
                                        </td>

                                        <!-- Scrutiny Transaction -->
                                        <td>
                                            <c:set var="txnFound" value="false"/>
                                            <c:forEach var="payment" items="${paymentMap[item.application.rtiApplicationId]}">
                                                <c:if test="${payment.amount == item.application.firstPaymentFees}">
                                                    <c:out value="${payment.uniqPgid}"/>
                                                    <c:set var="txnFound" value="true"/>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${!txnFound}">-</c:if>
                                        </td>

                                        <!-- Demand Fee Status -->
                                        <td>
                                            <c:choose>
                                                <c:when test="${item.application.workFlowStatus==1 || item.application.workFlowStatus==2}">
                                                    <span class="status-badge">Paid</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="status-badge">Unpaid</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>

                                        <!-- Demand Transaction -->
                                        <td>
                                            <c:set var="txnFound" value="false"/>
                                            <c:forEach var="payment" items="${paymentMap[item.application.rtiApplicationId]}">
                                                <c:if test="${payment.amount==item.application.applicationCost}">
                                                    <c:out value="${payment.uniqPgid}"/>
                                                    <c:set var="txnFound" value="true"/>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${!txnFound}">-</c:if>
                                        </td>

                                        <!-- Application Status -->
                                        <td>
                                            <span class="status-badge"><c:out value="${item.applicationStatus}"/></span>
                                        </td>

                                        <!-- Zone -->
                                        <td>
                                            <c:choose>
                                                <c:when test="${item.application.zone==1}">Civil Lines Fire Station</c:when>
                                                <c:when test="${item.application.zone==2}">Cotton Market Fire Station</c:when>
                                                <c:when test="${item.application.zone==3}">Ganjipeth Fire Station</c:when>
                                                <c:when test="${item.application.zone==4}">Lakadganj Fire Station</c:when>
                                                <c:when test="${item.application.zone==5}">Sakkardara Fire Station</c:when>
                                                <c:when test="${item.application.zone==6}">Kalamna Fire Station</c:when>
                                                <c:when test="${item.application.zone==7}">Sugat Nagar Fire Station</c:when>
                                                <c:when test="${item.application.zone==8}">Narendra Nagar Fire Station</c:when>
                                                <c:when test="${item.application.zone==9}">Trimurti Nagar Fire Station</c:when>
                                                <c:when test="${item.application.zone==10}">Wathoda Fire Station</c:when>
                                                <c:otherwise><c:out value="${item.application.zone}"/></c:otherwise>
                                            </c:choose>
                                        </td>

                                        <!-- Category -->
                                        <td><span class="category-badge category-citizen">Total</span></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="11" class="empty-records">No records found.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Citizen Section -->
    <div class="section-panel" id="citizenSection">
        <button type="button" class="section-toggle" onclick="toggleSection(this)">
            <span class="section-title-wrap">
                <span>Applications Received</span>
                <span class="section-count-badge"><c:out value="${requestScope.citizenCount}" /></span>
            </span>
            <span class="arrow">&#9660;</span>
        </button>

        <div class="section-content">
            <div class="section-inner">
                <div class="section-toolbar">
                    <div class="table-search">
                        <input type="text" class="search-input" id="citizenSearchInput"
                               placeholder="Search application no., name..."
                               oninput="filterTable('citizenTable', this.value)" />
                    </div>
                    <div class="toolbar-actions">
                        <button type="button" class="toolbar-btn export-btn"
                                onclick="exportTableToExcel('citizenTable','Applications_Received')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 3v12m0 0l-4-4m4 4l4-4" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M5 17v2a2 2 0 002 2h10a2 2 0 002-2v-2" stroke="currentColor" stroke-width="1.8" stroke-linecap="round"/>
                            </svg>
                            Export to Excel
                        </button>
                        <button type="button" class="toolbar-btn print-btn"
                                onclick="printTable('citizenTable','Applications Received')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M6 9V3h12v6M6 18h12v4H6v-4zM4 9h16a1 1 0 011 1v6a1 1 0 01-1 1h-3v3H7v-3H4a1 1 0 01-1-1v-6a1 1 0 011-1z" stroke="currentColor" stroke-width="1.5" stroke-linejoin="round"/>
                            </svg>
                            Print
                        </button>
                    </div>
                </div>
                <div class="table-wrapper">
                    <table cellpadding="0" cellspacing="1" class="dataGrid" id="citizenTable">
                        <thead>
                            <tr>
                                <td class="sr-no-col">Sr. No.</td>
                                <td>Application No.</td>
                                <td>Registration Date</td>
                                <td>Applicant Name</td>
                                <td>Scrutiny Fee</td>
                                <td>Scrutiny Transaction ID</td>
                                <td>Demand Fee Status</td>
                                <td>Demand Transaction ID</td>
                                <td>Application Status</td>
                                <td>Current Zone</td>
                                <td>Category</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty citizenList}">
                                    <c:forEach var="rtiApplnList" items="${citizenList}" varStatus="citizenStatus">
                                        <tr>
                                            <td class="sr-no-col"><c:out value="${citizenStatus.index + 1}"/></td>

                                            <td>
                                                <c:choose>
                                                    <c:when test="${requestScope.forLogin eq 'L1' or requestScope.isZoneUser}">
                                                        <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a title="<fmt:message key='list.link.EditOrViewLink'/>"
                                                           href="javascript:editRTIApplication(
                                                               '${rtiApplnList.rtiApplicationRefId}',
                                                               '${rtiApplnList.rtiApplicationId}'
                                                           );">
                                                            <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>

                                            <td><c:out value="${rtiApplnList.registrationDate}" /></td>
                                            <td><c:out value="${rtiApplnList.applicantName}" /></td>
                                            <td><c:set var="rawAmt" value="${rtiApplnList.firstPaymentFees}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %></td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.firstPaymentFees}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2 || rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Paid</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">Unpaid</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.applicationCost}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 0}">
                                                        <span class="status-badge">Citizen Form Submitted and scrutiny fee paid</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 3}">
                                                        <span class="status-badge">Citizen Payment Pending</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2}">
                                                        <span class="status-badge">Citizen Payment Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 5}">
                                                        <span class="status-badge">Rejected</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">N/A</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.zone == 1}">Civil Lines Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 2}">Cotton Market Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 3}">Ganjipeth Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 4}">Lakadganj Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 5}">Sakkardara Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 6}">Kalamna Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 7}">Sugat Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 8}">Narendra Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 9}">Trimurti Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 10}">Wathoda Fire Station</c:when>
                                                    <c:otherwise><c:out value="${rtiApplnList.zone}" /></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><span class="category-badge category-citizen">Citizen</span></td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="11" class="empty-records">No Citizen records found.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Forwarded Section -->
    <div class="section-panel" id="forwardedSection">
        <button type="button" class="section-toggle" onclick="toggleSection(this)">
            <span class="section-title-wrap">
                <span>Forwarded Fire Applications</span>
                <span class="section-count-badge"><c:out value="${requestScope.forwardedCount}" /></span>
            </span>
            <span class="arrow">&#9660;</span>
        </button>

        <div class="section-content">
            <div class="section-inner">
                <div class="section-toolbar">
                    <div class="table-search">
                        <input type="text" class="search-input" id="forwardedSearchInput"
                               placeholder="Search application no., name..."
                               oninput="filterTable('forwardedTable', this.value)" />
                    </div>
                    <div class="toolbar-actions">
                        <button type="button" class="toolbar-btn export-btn"
                                onclick="exportTableToExcel('forwardedTable','Forwarded_Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 3v12m0 0l-4-4m4 4l4-4" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M5 17v2a2 2 0 002 2h10a2 2 0 002-2v-2" stroke="currentColor" stroke-width="1.8" stroke-linecap="round"/>
                            </svg>
                            Export to Excel
                        </button>
                        <button type="button" class="toolbar-btn print-btn"
                                onclick="printTable('forwardedTable','Forwarded Fire Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M6 9V3h12v6M6 18h12v4H6v-4zM4 9h16a1 1 0 011 1v6a1 1 0 01-1 1h-3v3H7v-3H4a1 1 0 01-1-1v-6a1 1 0 011-1z" stroke="currentColor" stroke-width="1.5" stroke-linejoin="round"/>
                            </svg>
                            Print
                        </button>
                    </div>
                </div>
                <div class="table-wrapper">
                    <table cellpadding="0" cellspacing="1" class="dataGrid" id="forwardedTable">
                        <thead>
                            <tr>
                                <td class="sr-no-col">Sr. No.</td>
                                <td>Application No.</td>
                                <td>Registration Date</td>
                                <td>Applicant Name</td>
                                <td>Scrutiny Fee</td>
                                <td>Scrutiny Transaction ID</td>
                                <td>Demand Fee Status</td>
                                <td>Demand Transaction ID</td>
                                <td>Application Status</td>
                                <td>Current Zone</td>
                                <td>Category</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty forwardedList}">
                                    <c:forEach var="rtiApplnList" items="${forwardedList}" varStatus="forwardedStatus">
                                        <tr>
                                            <td class="sr-no-col"><c:out value="${forwardedStatus.index + 1}"/></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${requestScope.forLogin eq 'L1' or requestScope.isZoneUser}">
                                                        <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a title="<fmt:message key='list.link.EditOrViewLink'/>"
                                                           href="javascript:editRTIApplication(
                                                               '${rtiApplnList.rtiApplicationRefId}',
                                                               '${rtiApplnList.rtiApplicationId}'
                                                           );">
                                                            <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>

                                            <td><c:out value="${rtiApplnList.registrationDate}" /></td>
                                            <td><c:out value="${rtiApplnList.applicantName}" /></td>
                                            <td><c:set var="rawAmt" value="${rtiApplnList.firstPaymentFees}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %></td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.firstPaymentFees}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2 || rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Paid</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">Unpaid</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.applicationCost}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 0}">
                                                        <span class="status-badge">Zone Transfer</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 3}">
                                                        <span class="status-badge">Citizen Payment Pending</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2}">
                                                        <span class="status-badge">Citizen Payment Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 5}">
                                                        <span class="status-badge">Rejected</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">N/A</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.zone == 1}">Civil Lines Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 2}">Cotton Market Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 3}">Ganjipeth Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 4}">Lakadganj Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 5}">Sakkardara Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 6}">Kalamna Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 7}">Sugat Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 8}">Narendra Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 9}">Trimurti Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 10}">Wathoda Fire Station</c:when>
                                                    <c:otherwise><c:out value="${rtiApplnList.zone}" /></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><span class="category-badge category-forwarded">Forwarded</span></td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="11" class="empty-records">No Forwarded records found.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- L1 Section -->
    <div class="section-panel" id="l1Section">
        <button type="button" class="section-toggle" onclick="toggleSection(this)">
            <span class="section-title-wrap">
                <span>Fire Applications Received From L1 Level</span>
                <span class="section-count-badge"><c:out value="${requestScope.l1Count}" /></span>
            </span>
            <span class="arrow">&#9660;</span>
        </button>

        <div class="section-content">
            <div class="section-inner">
                <div class="section-toolbar">
                    <div class="table-search">
                        <input type="text" class="search-input" id="l1SearchInput"
                               placeholder="Search application no., name..."
                               oninput="filterTable('l1Table', this.value)" />
                    </div>
                    <div class="toolbar-actions">
                        <button type="button" class="toolbar-btn export-btn"
                                onclick="exportTableToExcel('l1Table','L1_Level_Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 3v12m0 0l-4-4m4 4l4-4" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M5 17v2a2 2 0 002 2h10a2 2 0 002-2v-2" stroke="currentColor" stroke-width="1.8" stroke-linecap="round"/>
                            </svg>
                            Export to Excel
                        </button>
                        <button type="button" class="toolbar-btn print-btn"
                                onclick="printTable('l1Table','Fire Applications Received From L1 Level')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M6 9V3h12v6M6 18h12v4H6v-4zM4 9h16a1 1 0 011 1v6a1 1 0 01-1 1h-3v3H7v-3H4a1 1 0 01-1-1v-6a1 1 0 011-1z" stroke="currentColor" stroke-width="1.5" stroke-linejoin="round"/>
                            </svg>
                            Print
                        </button>
                    </div>
                </div>
                <div class="table-wrapper">
                    <table cellpadding="0" cellspacing="1" class="dataGrid" id="l1Table">
                        <thead>
                            <tr>
                                <td class="sr-no-col">Sr. No.</td>
                                <td>Application No.</td>
                                <td>Registration Date</td>
                                <td>Applicant Name</td>
                                <td>Scrutiny Fee</td>
                                <td>Scrutiny Transaction ID</td>
                                <td>Demand Fee Status</td>
                                <td>Demand Transaction ID</td>
                                <td>Application Status</td>
                                <td>Current Zone</td>
                                <td>Category</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty l1List}">
                                    <c:forEach var="rtiApplnList" items="${l1List}" varStatus="l1Status">
                                        <tr>
                                            <td class="sr-no-col"><c:out value="${l1Status.index + 1}"/></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${requestScope.forLogin eq 'L1' or requestScope.isZoneUser}">
                                                        <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a title="<fmt:message key='list.link.EditOrViewLink'/>"
                                                           href="javascript:editRTIApplication(
                                                               '${rtiApplnList.rtiApplicationRefId}',
                                                               '${rtiApplnList.rtiApplicationId}'
                                                           );">
                                                            <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><c:out value="${rtiApplnList.registrationDate}" /></td>
                                            <td><c:out value="${rtiApplnList.applicantName}" /></td>
                                            <td><c:set var="rawAmt" value="${rtiApplnList.firstPaymentFees}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %></td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.firstPaymentFees}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2 || rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Paid</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">Unpaid</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.applicationCost}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 0}">
                                                        <span class="status-badge">Pending</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 3}">
                                                        <span class="status-badge">Citizen Payment Pending</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2}">
                                                        <span class="status-badge">Citizen Payment Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 5}">
                                                        <span class="status-badge">Rejected</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">N/A</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.zone == 1}">Civil Lines Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 2}">Cotton Market Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 3}">Ganjipeth Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 4}">Lakadganj Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 5}">Sakkardara Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 6}">Kalamna Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 7}">Sugat Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 8}">Narendra Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 9}">Trimurti Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 10}">Wathoda Fire Station</c:when>
                                                    <c:otherwise><c:out value="${rtiApplnList.zone}" /></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><span class="category-badge category-l1">L1</span></td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="11" class="empty-records">No L1 records found.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Completed applications Section -->
    <div class="section-panel" id="completedSection">
        <button type="button" class="section-toggle" onclick="toggleSection(this)">
            <span class="section-title-wrap">
                <span>Completed Applications</span>
                <span class="section-count-badge"><c:out value="${requestScope.completedCount}" /></span>
            </span>
            <span class="arrow">&#9660;</span>
        </button>

        <div class="section-content">
            <div class="section-inner">
                <div class="section-toolbar">
                    <div class="table-search">
                        <input type="text" class="search-input" id="completedSearchInput"
                               placeholder="Search application no., name.."
                               oninput="filterTable('completedTable', this.value)" />
                    </div>
                    <div class="toolbar-actions">
                        <button type="button" class="toolbar-btn export-btn"
                                onclick="exportTableToExcel('completedTable','Completed_Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 3v12m0 0l-4-4m4 4l4-4" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M5 17v2a2 2 0 002 2h10a2 2 0 002-2v-2" stroke="currentColor" stroke-width="1.8" stroke-linecap="round"/>
                            </svg>
                            Export to Excel
                        </button>
                        <button type="button" class="toolbar-btn print-btn"
                                onclick="printTable('completedTable','Completed Applications')">
                            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M6 9V3h12v6M6 18h12v4H6v-4zM4 9h16a1 1 0 011 1v6a1 1 0 01-1 1h-3v3H7v-3H4a1 1 0 01-1-1v-6a1 1 0 011-1z" stroke="currentColor" stroke-width="1.5" stroke-linejoin="round"/>
                            </svg>
                            Print
                        </button>
                    </div>
                </div>
                <div class="table-wrapper">
                    <table cellpadding="0" cellspacing="1" class="dataGrid" id="completedTable">
                        <thead>
                            <tr>
                                <td class="sr-no-col">Sr. No.</td>
                                <td>Application No.</td>
                                <td>Registration Date</td>
                                <td>Applicant Name</td>
                                <td>Scrutiny Fee</td>
                                <td>Scrutiny Transaction ID</td>
                                <td>Demand Fee Status</td>
                                <td>Demand Transaction ID</td>
                                <td>Application Status</td>
                                <td>Current Zone</td>
                                <td>Category</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty completedList}">
                                    <c:forEach var="rtiApplnList" items="${completedList}" varStatus="completedStatus">
                                        <tr>
                                            <td class="sr-no-col"><c:out value="${completedStatus.index + 1}"/></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${requestScope.forLogin eq 'L1' or requestScope.isZoneUser}">
                                                        <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a title="<fmt:message key='list.link.EditOrViewLink'/>"
                                                           href="javascript:editRTIApplication(
                                                               '${rtiApplnList.rtiApplicationRefId}',
                                                               '${rtiApplnList.rtiApplicationId}'
                                                           );">
                                                            <c:out value="${rtiApplnList.rtiApplnNumber}" />
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><c:out value="${rtiApplnList.registrationDate}" /></td>
                                            <td><c:out value="${rtiApplnList.applicantName}" /></td>
                                            <td><c:set var="rawAmt" value="${rtiApplnList.firstPaymentFees}"/><%= fmtIndianAmount(pageContext.getAttribute("rawAmt")) %></td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.firstPaymentFees}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2 || rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Paid</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">Unpaid</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:set var="txnFound" value="false" />
                                                <c:forEach var="payment" items="${paymentMap[rtiApplnList.rtiApplicationId]}">
                                                    <c:if test="${payment.amount == rtiApplnList.applicationCost}">
                                                        <c:out value="${payment.uniqPgid}" />
                                                        <c:set var="txnFound" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!txnFound}">No transaction details found</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 0 && !rtiApplnList.forwardedToL1 && empty rtiApplnList.remarkforL2}">
                                                        <span class="status-badge">Citizen Form Submitted and scrutiny fee paid</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 0 && rtiApplnList.forwardedToL1 && empty rtiApplnList.remarkforL2}">
                                                        <span class="status-badge">Zone Transfer</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 0 && !rtiApplnList.forwardedToL1 && not empty rtiApplnList.remarkforL2}">
                                                        <span class="status-badge">Pending</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 3}">
                                                        <span class="status-badge">Citizen Payment Pending</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 2}">
                                                        <span class="status-badge">Citizen Payment Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 1}">
                                                        <span class="status-badge">Completed</span>
                                                    </c:when>
                                                    <c:when test="${rtiApplnList.workFlowStatus == 5}">
                                                        <span class="status-badge">Rejected</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="status-badge">N/A</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rtiApplnList.zone == 1}">Civil Lines Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 2}">Cotton Market Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 3}">Ganjipeth Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 4}">Lakadganj Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 5}">Sakkardara Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 6}">Kalamna Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 7}">Sugat Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 8}">Narendra Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 9}">Trimurti Nagar Fire Station</c:when>
                                                    <c:when test="${rtiApplnList.zone == 10}">Wathoda Fire Station</c:when>
                                                    <c:otherwise><c:out value="${rtiApplnList.zone}" /></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><span class="category-badge category-citizen">Completed</span></td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="11" class="empty-records">No Completed records found.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <input type="hidden" id="rtiApplicationRefId" name="rtiApplicationRefId" value="" />
    <input type="hidden" id="rtiApplicationId" name="rtiApplicationId" value="" />
    <input type="hidden" id="SortBy" name="SortBy" value="<c:out value="${requestScope.SortBy}"/>" />
    <input type="hidden" id="OrderBy" name="OrderBy" value="<c:out value="${requestScope.OrderBy}"/>" />

    <script type="text/javascript">
        insert_image('${contextRoot}');
    </script>
</div>
