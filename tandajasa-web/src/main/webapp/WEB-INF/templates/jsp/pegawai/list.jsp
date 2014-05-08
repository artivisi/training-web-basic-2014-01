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
        
        <a href="form">Tambah Data</a>
        
        <table border="1">
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
                        <a href="form?id=${x.id}">edit</a> | 
                        <a href="delete?id=${x.id}">hapus</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
