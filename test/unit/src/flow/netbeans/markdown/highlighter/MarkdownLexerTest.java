package flow.netbeans.markdown.highlighter;

import flow.netbeans.markdown.options.MarkdownGlobalOptions;
import org.junit.Test;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenHierarchy;

import static org.junit.Assert.*;

public class MarkdownLexerTest extends MarkdownLexerTestBase {

    public MarkdownLexerTest() {
    }

    @Test
    public void testCreate() {
        String content = "\n";
        Language<MarkdownTokenId> language = MarkdownTokenId.language();
        TokenHierarchy<?> hierarchy = TokenHierarchy.create(content, language);
        assertFalse(hierarchy.tokenSequence().isEmpty());
    }

    @Test
    public void testParagraphs() throws Exception {
        assertEquals(getGoldenFileContent("paragraphs.pass"), getTestResult("paragraphs.md"));
    }
    
    @Test
    public void testHeadings() throws Exception {
        assertEquals(getGoldenFileContent("headings.pass"), getTestResult("headings.md"));
    }

    @Test
    public void testNested() throws Exception {
        assertEquals(getGoldenFileContent("nested.pass"), getTestResult("nested.md"));
    }

    @Test
    public void testPlain() throws Exception {
        assertEquals(getGoldenFileContent("plain.pass"), getTestResult("plain.md"));
    }

    @Test
    public void testTaskListItemsEnabled() throws Exception {
        MarkdownGlobalOptions options = MarkdownGlobalOptions.getInstance();
        options.setTaskListItems(true);
        try {
            assertEquals(getGoldenFileContent("tasklistitems_enabled.pass"), getTestResult("tasklistitems.md"));
        } finally {
            options.setTaskListItems(false);
        }
    }
}
