<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade bd-example-modal-lg" id="collapseUpdateProduct" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding: 20px">
            <div class="modal-header  d-flex justify-content-center ">
                <h3 class="modal-title " id="collapseUpdateProduct">Thay đổi thông tin <span class="text-warning">SẢN PHẨM</span> </h3>
            </div>
            <div class="modal-body">
                <form>
                    <form class="form" action="" method="Post">
                        <div class="form-group">
                            <label for="newShopName" class="text-black">Tên sản phẩm</label><br>
                            <input type="text" name="productName" id="newShopName"  class="form-control" autocomplete="off" required="required" placeholder="Món ăn">
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="newShopDescription" class="text-black">Đơn giá</label><br>
                                    <input type="number" name="productPrice" id="newShopDescription"  class="form-control" autocomplete="off" required="required" placeholder="VNĐ">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="inputImgProduct">Ảnh</label>
                                    <input type="file" class="form-control-file" id="inputImgProduct">
                                </div>
                            </div>
                        </div>
                        </div>
                        <div class="form-group">
                            <input style="width: 50%" type="submit" name="newShop" class="btn btn-info btn-md" value="Lưu thay đổi">
                            <button style="width: 49%" type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
                        </div>
                    </form>
            </div>
        </div>
    </div>
</div>
