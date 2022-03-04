<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  
    <html>
      <head>
        <title>Competicions Mangogym</title>
        <link rel="stylesheet" href="estilscurses.css"/>
      </head>
      <body>
      <div class="dalt">
        <h1>Curses disponibles</h1>
        
        
        <a href="../php/pagact.php">Tornar enrere</a>
       
      </div>  

        <div id="curses">
          <xsl:for-each select="curses/cursa">
            <xsl:sort select="idcursa"></xsl:sort>
            <div class="cursa">
                <h3>idcursa: <span><xsl:value-of select="idcursa"></xsl:value-of></span></h3>
                <h4>descripcio: <span><xsl:value-of select="descripcio"></xsl:value-of></span></h4>
                <h4>durada: <span><xsl:value-of select="durada"></xsl:value-of></span></h4>
                <img src="imatges/{portada}" alt="imatge" />
                <input type="button" value="Inscriu-te" id="boto"></input>
              </div>
          </xsl:for-each>
        </div>
        
        <script src="funcions.js"></script>
        
      </body>
    </html>
    
  </xsl:template>
</xsl:stylesheet>
