package com.prosayj.springboot.utils.parseswagger.assemble;

import com.itextpdf.text.Font;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

/**
 * 字体提供类, 更改 默认的字体
 */
public class FontProvider extends XMLWorkerFontProvider {
    public FontProvider() {
        super(null, null);
    }

    @Override
    public Font getFont(final String fontname, String encoding, float size,
                        final int style) {

        String fntname = fontname;
        if (fntname == null) {
            fntname = "宋体";
        }
        return super.getFont(fntname, encoding, size, style);
    }
}
