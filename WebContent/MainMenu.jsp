<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>mainMenu</title>
</head>

<body>
<a href="<s:url action="addpaper"/>">添加论文</a>
<div align="center">
        <h3>我的论文</h3>
    </div>

    <table border="1" width="100%">

        <tr>
            <th align="center" width="30%">
                编号
            </th>
            <th align="center" width="25%">
                题目
            </th>
            <th align="center" width="10%">
                作者
            </th>
            <th align="center" width="10%">
                时间
            </th>
            <th align="center" width="15%">
                操作
            </th>
        </tr>

        <s:iterator value="user.papers">
            <tr>
                <td align="left">
                    <s:property value="paperID"/>
                </td>
                <td align="left">
                    <s:property value="title"/>
                </td>
                <td align="center">
                    <s:property value="author"/>
                </td>
                <td align="center">
                    <s:property value="date"/>
                </td>
                <td align="center">

                    <a href="<s:url action="Paper_delete"><s:param name="paperID" value="paperID"/></s:url>">
                        删除
                    </a>
                    &nbsp;
                    <a href="<s:url action="Paper_edit"><s:param name="paperID" value="paperID"/></s:url>">
                        编辑
                    </a>

                </td>
            </tr>
        </s:iterator>

    </table>
</body>
</html>
