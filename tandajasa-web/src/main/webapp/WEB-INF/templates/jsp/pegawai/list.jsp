<%-- 
    Document   : list
    Created on : May 8, 2014, 7:01:03 PM
    Author     : endy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pegawai</title>
    </head>
    <body>
        <h1>Daftar Pegawai</h1>

        <a href="form" class="btn btn-primary">
            <span class="glyphicon glyphicon-plus"></span>
            Tambah Data
        </a>

        <form class="form-inline" role="form">
            <div class="form-group">
                <label class="sr-only" for="cari">Cari Pegawai</label>
                <input type="text" name="search" class="form-control" id="cari" placeholder="Masukkan keyword">
            </div>
            <button type="submit" class="btn btn-default">Cari</button>
        </form>
        <hr>

        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
                <tr>
                    <th>NIP</th>
                    <th>Nama</th>
                    <th>Golongan</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="x" items="${daftarPegawai}">
                    <tr>
                        <td>${x.nip}</td>
                        <td>${x.nama}</td>
                        <td>${x.golongan.kode}</td>
                        <td>
                            <a class="btn" href="form?id=${x.id}">
                                <span class="glyphicon glyphicon-pencil"></span>
                                edit
                            </a> | 
                            <a class="btn" href="delete?id=${x.id}">
                                <span class="glyphicon glyphicon-remove"></span>
                                hapus
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
