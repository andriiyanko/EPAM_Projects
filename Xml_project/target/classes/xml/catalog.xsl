<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body style="font-family: Arial; font-size: 12pt; background-color: #EEE">
        <div style="background-color: green; color: black;">
          <h2>My CD Collection</h2>
        </div>
        <table border="3">
          <tr bgcolor="#2E9AFE">
            <th>Title</th>
            <th>Artist</th>
            <th>Country</th>
            <th>Company</th>
            <th>Price</th>
            <th>Year</th>
          </tr>

          <xsl:for-each select="catalog/cd">

            <tr>

              <td><xsl:value-of select="title"/></td>
              <td><xsl:value-of select="artist"/></td>
              <td><xsl:value-of select="country"/></td>
              <td><xsl:value-of select="company"/></td>


            </tr>

          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
