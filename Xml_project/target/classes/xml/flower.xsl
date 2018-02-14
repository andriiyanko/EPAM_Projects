<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:nsm="flowers">

    <xsl:template match="/">
        <html>
            <head>
                <link rel='stylesheet' href='style.css' type='text/css'/>
            </head>
            <body>
                <div >
                    <h2>My Flower Garden</h2>
                </div>
                <table align ='center'>
                    <tr bgcolor="#2E9AFE">
                        <th>Name</th>
                        <th>Soil</th>
                        <th>Origin</th>
                        <th>Color_Stem</th>
                        <th>Color_leaf</th>
                        <th>Flower_Avarage_Size</th>
                        <th>Temperature</th>
                        <th>Lighting</th>
                        <th>Watering</th>
                        <th>Multiplying</th>
                    </tr>
                    <xsl:for-each select="nsm:flowers/nsm:flower">

                        <tr>
                            <td><xsl:value-of select="nsm:name"/></td>
                            <td><xsl:value-of select="nsm:soil"/></td>
                            <td><xsl:value-of select="nsm:origin"/></td>
                            <td><xsl:value-of select="nsm:visual_parameters/nsm:color_stem"/></td>
                            <td><xsl:value-of select="nsm:visual_parameters/nsm:color_leaf"/></td>
                            <td><xsl:value-of select="nsm:visual_parameters/nsm:flower_average_size"/></td>
                            <td><xsl:value-of select="nsm:growing_tips/nsm:temperature"/></td>
                            <td><xsl:value-of select="nsm:growing_tips/nsm:lighting"/></td>
                            <td><xsl:value-of select="nsm:growing_tips/nsm:watering"/></td>
                            <td><xsl:value-of select="nsm:multiplying"/></td>
                        </tr>

                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>