<%-- 
    Document   : form
    Created on : May 8, 2014, 7:43:07 PM
    Author     : endy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Pegawai</title>
    </head>
    <body>
        <h1>Edit Pegawai</h1>
        
        <form:form commandName="pegawai">
            <table border="1">
                <tbody>
                    <tr>
                        <td>NIP</td>
                        <td>
                            <form:input path="nip"/>
                        </td>
                        <td>
                            <form:errors path="nip" />
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <form:input path="nama"/>
                        </td>
                        <td>
                            <form:errors path="nama" />
                        </td>
                    </tr>
                    <tr>
                        <td>Golongan</td>
                        <td>
                            <form:select path="golongan">
                                <form:option value="">Pilih Golongan</form:option>
                                <form:options 
                                    items="${daftarGolongan}"
                                    itemLabel="kode"
                                    itemValue="id"
                                />
                            </form:select>
                        </td>
                        <td>
                            <form:errors path="golongan" />
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="Simpan">
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                </tbody>
            </table>

        </form:form>
    </body>
</html>
