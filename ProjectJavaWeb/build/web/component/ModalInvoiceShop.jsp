<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade bd-example-modal-lg" id="modalInvoiceShop" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" >
            <table class="table table-hover">
                <thead class="table-warning">
                    <tr>
                        <th>Title</th>
                        <th>Người mua</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Giá 1 sản phẩm( tại thời điểm mua)</th>
                        <th>Ghi chú</th>
                        <th>Địa chỉ</th>
                        <th>SĐT</th>
                        <th><input type="date" name="orderTime" required="required" style="border: none;border-radius: 5px;padding: 5px;outline: none"/></th>
                        <th>Tổng</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${shop.invoiceFormat}">
                        <c:set var="count" value="0" scope="page" />
                        <tr>
                            <td><h5>Đơn hàng</h5></td>
                            <td>${x.value.get(0).userName}</td>
                            <td>${x.value.get(0).productName}</td>
                            <td>${x.value.get(0).quatity}</td>
                            <td>${x.value.get(0).unitPrice}</td>
                            <td>${x.value.get(0).note}</td>
                            <td>${x.value.get(0).address}</td>
                            <td>${x.value.get(0).phoneNumber}</td>
                            <td style="font-weight: bold">${x.value.get(0).orderTime}</td>
                            <td>${x.value.get(0).quatity*x.value.get(0).unitPrice}VNĐ</td>
                            <c:set var="count" value="${count + x.value.get(0).quatity*x.value.get(0).unitPrice}" scope="page"/>
                        </tr>
                        <c:forEach var="xy" items="${x.value}" begin="1">
                            <tr>
                                <td></td>
                                <td>${xy.userName}</td>
                                <td>${xy.productName}</td>
                                <td>${xy.quatity}</td>
                                <td>${xy.unitPrice}</td>
                                <td>${xy.note}</td>
                                <td>${xy.address}</td>
                                <td>${xy.phoneNumber}</td>
                                <td style="font-weight: bold">${xy.orderTime}</td>
                                <td>${xy.quatity*xy.unitPrice}VNĐ</td>
                                <c:set var="count" value="${count + xy.quatity*xy.unitPrice}" scope="page"/>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td style="text-align: center">
                                <h6>Tổng đơn hàng</h6>
                                <c:out value="${count}VNĐ"></c:out>
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
