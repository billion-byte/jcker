package org.jcker.utils;

import com.vdurmont.emoji.EmojiParser;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-25 at 3:48 AM
 *
 * @version 1.0
 */
public class JckerUtils {
    /**
     * markdown转换为html
     *
     * @param markdown
     * @return
     */
    public static String mdToHtml(String markdown) {
        if (StringUtils.isEmpty(markdown)) {
            return "";
        }

        List<Extension> extensions = Arrays.asList(TablesExtension.create());
        Parser parser     = Parser.builder().extensions(extensions).build();
        Node document   = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .attributeProviderFactory(context -> new LinkAttributeProvider())
                .extensions(extensions).build();

        String content = renderer.render(document);
        content = emoji(content);

/*        // 支持网易云音乐输出
        if (TaleConst.BCONF.getBoolean(ENV_SUPPORT_163_MUSIC, true) && content.contains(MP3_PREFIX)) {
            content = content.replaceAll(MUSIC_REG_PATTERN, MUSIC_IFRAME);
        }
        // 支持gist代码输出
        if (TaleConst.BCONF.getBoolean(ENV_SUPPORT_GIST, true) && content.contains(GIST_PREFIX_URL)) {
            content = content.replaceAll(GIST_REG_PATTERN, GIST_REPLATE_PATTERN);
        }*/
        return content;
    }
    static class LinkAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            if (node instanceof Link) {
                attributes.put("target", "_blank");
            }
        }
    }

    /**
     * An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!
     * <p>
     * 这种格式的字符转换为emoji表情
     *
     * @param value
     * @return
     */
    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }
}
