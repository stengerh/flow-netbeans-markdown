package flow.netbeans.markdown.options;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;
import org.pegdown.Extensions;

/**
 * @see
 * https://github.com/nicoulaj/idea-markdown/blob/master/src/main/java/net/nicoulaj/idea/markdown/settings/MarkdownGlobalSettings.java
 */
public final class MarkdownGlobalOptions {

    private static final MarkdownGlobalOptions INSTANCE = new MarkdownGlobalOptions();

    /** The default for whether to use a custom preview refresh interval. */
    private static final boolean DEFAULT_USE_CUSTOM_PREVIEW_REFRESH_INTERVAL = false;
    /** The default preview refresh interval in milliseconds. */
    private static final int DEFAULT_PREVIEW_REFRESH_INTERVAL = 1000;
    /** The minimum preview refresh interval in milliseconds. */
    static final int MIN_PREVIEW_INTERVAL = 10;
    /** The maximum preview refresh interval in milliseconds. */
    static final int MAX_PREVIEW_INTERVAL = 10000;

    private static final String SMARTS = "SMARTS"; // NOI18N
    private static final String QUOTES = "QUOTES"; // NOI18N
    private static final String ABBREVIATIONS = "ABBREVIATIONS"; // NOI18N
    private static final String DEFINITION_LISTS = "DEFINITION_LISTS"; // NOI18N
    private static final String FENCED_CODE_BLOCKS = "FENCED_CODE_BLOCKS"; // NOI18N
    private static final String HARDWRAPS = "HARDWRAPS"; // NOI18N
    private static final String AUTOLINKS = "AUTOLINKS"; // NOI18N
    private static final String WIKILINKS = "WIKILINKS"; // NOI18N
    private static final String TABLES = "TABLES"; // NOI18N
    private static final String STRIKETHROUGH = "STRIKETHROUGH"; // NOI18N
    private static final String HTML_BLOCK_SUPPRESSION = "HTML_BLOCK_SUPPRESSION"; // NOI18N
    private static final String INLINE_HTML_SUPPRESSION = "INLINE_HTML_SUPPRESSION"; // NOI18N
    private static final String ANCHORLINKS = "ANCHORLINKS"; // NOI18N
    private static final String ATXHEADERSPACE = "ATXHEADERSPACE"; // NOI18N
    private static final String FORCELISTITEMPARA = "FORCELISTITEMPARA"; // NOI18N
    private static final String RELAXEDHRULES = "RELAXEDHRULES"; // NOI18N
    private static final String TASKLISTITEMS = "TASKLISTITEMS"; // NOI18N
    private static final String EXTANCHORLINKS = "EXTANCHORLINKS"; // NOI18N
    private static final String HTML_TEMPLATE = "HTML_TEMPLATE"; // NOI18N
    private static final String VIEW_HTML_ON_SAVE = "VIEW_HTML_ON_SAVE"; // NOI18N
    private static final String SAVE_IN_SOURCE_DIR = "SAVE_IN_SOURCE_DIR"; // NOI18N
    private static final String EXPORT_ON_SAVE = "EXPORT_ON_SAVE"; // NOI18N
    private static final String USE_CUSTOM_PREVIEW_REFRESH_INTERVAL = "USE_CUSTOM_PREVIEW_INTERVAL";
    private static final String CUSTOM_PREVIEW_REFRESH_INTERVAL = "CUSTOM_PREVIEW_INTERVAL";

    // typing hooks
    private static final String TYPING_HOOKS = "TYPING_HOOKS"; // NOI18N
    private static final String AUTO_ADDITION_LIST = "AUTO_ADDITION_LIST"; // NOI18N
    private static final String REMOVE_EMPTY_LIST = "REMOVE_EMPTY_LIST"; // NOI18N
    private static final String REORDER_ORDERED_LIST = "REORDER_ORDERED_LIST"; // NOI18N
    private static final String REMOVE_ORDERED_LIST = "REMOVE_ORDERED_LIST"; // NOI18N
    private static final String FX_HTML_VIEW_ENABLED = "FX_HTML_VIEW_ENABLED"; // NOI18N

    public static MarkdownGlobalOptions getInstance() {
        return INSTANCE;
    }
    private MarkdownGlobalOptions() {
    }

    private void bindPreferences() {
        abbreviations = isAbbreviations();
        autoLinks = isAutoLinks();
        definitions = isDefinitions();
        fencedCodeBlocks = isFencedCodeBlocks();
        hardWraps = isHardWraps();
        suppressHTMLBlocks = isSuppressHTMLBlocks();
        suppressInlineHTML = isSuppressInlineHTML();
        quotes = isQuotes();
        smarts = isSmarts();
        tables = isTables();
        wikiLinks = isWikiLinks();
        strikeThrough = isStrikeThrough();
        anchorLinks = isAnchorLinks();
        atxHeaderSpace = isAtxHeaderSpace();
        forceListItemPara = isForceListItemPara();
        relaxedHRules = isRelaxedHRules();
        taskListItems = isTaskListItems();
        extAnchorLinks = isExtAnchorLinks();
    }

    /**
     * Whether the "SmartyPants style pretty ellipsises, dashes and apostrophes"
     * extension should be enabled.
     */
    private boolean smarts = false;
    /**
     * Whether the "SmartyPants style pretty single and double quotes" extension
     * should be enabled.
     */
    private boolean quotes = false;
    /**
     * Whether the "PHP Markdown Extra style abbreviations" extension should be
     * enabled.
     */
    private boolean abbreviations = false;
    /**
     * Whether the "PHP Markdown Extra style definition lists" extension should
     * be enabled.
     */
    private boolean definitions = false;
    /**
     * Whether the "PHP Markdown Extra style fenced code blocks" extension
     * should be enabled.
     */
    private boolean fencedCodeBlocks = false;
    /**
     * Whether the "Github style hard wraps parsing as HTML linebreaks"
     * extension should be enabled.
     */
    private boolean hardWraps = false;
    /**
     * Whether the "Github style plain auto-links" extension should be enabled.
     */
    private boolean autoLinks = false;
    /**
     * Whether the "Wiki-style links" extension should be enabled.
     */
    private boolean wikiLinks = false;
    /**
     * Whether the "MultiMarkdown style tables support" extension should be
     * enabled.
     */
    private boolean tables = false;
    /**
     * Whether the "StrikeThrough" extension should be
     * enabled.
     */
    private boolean strikeThrough = false;
    /**
     * Whether the "Suppress HTML blocks" extension should be enabled.
     */
    private boolean suppressHTMLBlocks = false;
    /**
     * Whether the "Suppress inline HTML tags" extension should be enabled.
     */
    private boolean suppressInlineHTML = false;

    private boolean anchorLinks = false;
    private boolean atxHeaderSpace = false;
    private boolean forceListItemPara = false;
    private boolean relaxedHRules = false;
    private boolean taskListItems = false;
    private boolean extAnchorLinks = false;

    /**
     * Get the extensions value to setup PegDown parser with.
     *
     * @return the value to use with {@link org.pegdown.PegDownProcessor(int)}
     */
    public int getExtensionsValue() {
        bindPreferences();

        return (smarts ? Extensions.SMARTS : 0)
                + (quotes ? Extensions.QUOTES : 0)
                + (abbreviations ? Extensions.ABBREVIATIONS : 0)
                + (hardWraps ? Extensions.HARDWRAPS : 0)
                + (autoLinks ? Extensions.AUTOLINKS : 0)
                + (wikiLinks ? Extensions.WIKILINKS : 0)
                + (tables ? Extensions.TABLES : 0)
                + (definitions ? Extensions.DEFINITIONS : 0)
                + (fencedCodeBlocks ? Extensions.FENCED_CODE_BLOCKS : 0)
                + (suppressHTMLBlocks ? Extensions.SUPPRESS_HTML_BLOCKS : 0)
                + (suppressInlineHTML ? Extensions.SUPPRESS_INLINE_HTML : 0)
                + (strikeThrough ? Extensions.STRIKETHROUGH : 0)
                + (anchorLinks ? Extensions.ANCHORLINKS : 0)
                + (atxHeaderSpace ? Extensions.ATXHEADERSPACE : 0)
                + (forceListItemPara ? Extensions.FORCELISTITEMPARA : 0)
                + (relaxedHRules ? Extensions.RELAXEDHRULES : 0)
                + (taskListItems ? Extensions.TASKLISTITEMS : 0)
                + (extAnchorLinks ? Extensions.EXTANCHORLINKS : 0);
    }

    public boolean isSmarts() {
        return getPreferences().getBoolean(SMARTS, false);
    }

    public void setSmarts(boolean smarts) {
        getPreferences().putBoolean(SMARTS, smarts);
    }

    public boolean isQuotes() {
        return getPreferences().getBoolean(QUOTES, false);
    }

    public void setQuotes(boolean quotes) {
        getPreferences().putBoolean(QUOTES, quotes);
    }

    public boolean isAbbreviations() {
        return getPreferences().getBoolean(ABBREVIATIONS, false);
    }

    public void setAbbreviations(boolean abbreviations) {
        getPreferences().putBoolean(ABBREVIATIONS, abbreviations);
    }

    public boolean isDefinitions() {
        return getPreferences().getBoolean(DEFINITION_LISTS, false);
    }

    public void setDefinitions(boolean definitions) {
        getPreferences().putBoolean(DEFINITION_LISTS, definitions);
    }

    public boolean isFencedCodeBlocks() {
        return getPreferences().getBoolean(FENCED_CODE_BLOCKS, false);
    }

    public void setFencedCodeBlocks(boolean fencedCodeBlocks) {
        getPreferences().putBoolean(FENCED_CODE_BLOCKS, fencedCodeBlocks);
    }

    public boolean isHardWraps() {
        return getPreferences().getBoolean(HARDWRAPS, false);
    }

    public void setHardWraps(boolean hardWraps) {
        getPreferences().putBoolean(HARDWRAPS, hardWraps);
    }

    public boolean isAutoLinks() {
        return getPreferences().getBoolean(AUTOLINKS, false);
    }

    public void setAutoLinks(boolean autoLinks) {
        getPreferences().putBoolean(AUTOLINKS, autoLinks);
    }

    public boolean isWikiLinks() {
        return getPreferences().getBoolean(WIKILINKS, false);
    }

    public void setWikiLinks(boolean wikiLinks) {
        getPreferences().putBoolean(WIKILINKS, wikiLinks);
    }

    public boolean isTables() {
        return getPreferences().getBoolean(TABLES, false);
    }

    public void setTables(boolean tables) {
        getPreferences().putBoolean(TABLES, tables);
    }

    public boolean isStrikeThrough() {
        return getPreferences().getBoolean(STRIKETHROUGH, false);
    }

    public void setStrikeThrough(boolean strikeThrough) {
        getPreferences().putBoolean(STRIKETHROUGH, strikeThrough);
    }

    public boolean isSuppressHTMLBlocks() {
        return getPreferences().getBoolean(HTML_BLOCK_SUPPRESSION, false);
    }

    public void setSuppressHTMLBlocks(boolean suppressHTMLBlocks) {
        getPreferences().putBoolean(HTML_BLOCK_SUPPRESSION, suppressHTMLBlocks);
    }

    public boolean isSuppressInlineHTML() {
        return getPreferences().getBoolean(INLINE_HTML_SUPPRESSION, false);
    }

    public void setSuppressInlineHTML(boolean suppressInlineHTML) {
        getPreferences().putBoolean(INLINE_HTML_SUPPRESSION, suppressInlineHTML);
    }

    public boolean isAnchorLinks() {
        return getPreferences().getBoolean(ANCHORLINKS, false);
    }

    public void setAnchorLinks(boolean anchorLinks) {
        getPreferences().putBoolean(ANCHORLINKS, anchorLinks);
    }

    public boolean isAtxHeaderSpace() {
        return getPreferences().getBoolean(ATXHEADERSPACE, false);
    }

    public void setAtxHeaderSpace(boolean atxHeaderSpace) {
        getPreferences().putBoolean(ATXHEADERSPACE, atxHeaderSpace);
    }

    public boolean isForceListItemPara() {
        return getPreferences().getBoolean(FORCELISTITEMPARA, false);
    }

    public void setForceListItemPara(boolean forceListItemPara) {
        getPreferences().putBoolean(FORCELISTITEMPARA, forceListItemPara);
    }

    public boolean isRelaxedHRules() {
        return getPreferences().getBoolean(RELAXEDHRULES, false);
    }

    public void setRelaxedHRules(boolean relaxedHRules) {
        getPreferences().putBoolean(RELAXEDHRULES, relaxedHRules);
    }

    public boolean isTaskListItems() {
        return getPreferences().getBoolean(TASKLISTITEMS, false);
    }

    public void setTaskListItems(boolean taskListItems) {
        getPreferences().putBoolean(TASKLISTITEMS, taskListItems);
    }

    public boolean isExtAnchorLinks() {
        return getPreferences().getBoolean(EXTANCHORLINKS, false);
    }

    public void setExtAnchorLinks(boolean extAnchorLinks) {
        getPreferences().putBoolean(EXTANCHORLINKS, extAnchorLinks);
    }

    public String getHtmlTemplate() {
        return getPreferences().get(HTML_TEMPLATE, MarkdownPanel.getDefaultHtmlTemplate());
    }

    public void setHtmlTemplate(String htmlTemplate) {
        getPreferences().put(HTML_TEMPLATE, htmlTemplate);
    }

    public boolean isViewHtmlOnSave() {
        return getPreferences().getBoolean(VIEW_HTML_ON_SAVE, false);
    }

    public void setViewHtmlOnSave(boolean onSave) {
        getPreferences().putBoolean(VIEW_HTML_ON_SAVE, onSave);
    }

    public boolean isSaveInSourceDir() {
        return getPreferences().getBoolean(SAVE_IN_SOURCE_DIR, false);
    }

    public void setSaveInSourceDir(boolean saveIn) {
        getPreferences().putBoolean(SAVE_IN_SOURCE_DIR, saveIn);
    }

    public boolean isExportOnSave() {
        return getPreferences().getBoolean(EXPORT_ON_SAVE, false);
    }

    public void setExportOnSave(boolean export) {
        getPreferences().putBoolean(EXPORT_ON_SAVE, export);
    }

    // typing hooks
    public boolean isTypingHooks() {
        return getPreferences().getBoolean(TYPING_HOOKS, false);
    }

    public void setTypingHooks(boolean isTypingHooks) {
        getPreferences().putBoolean(TYPING_HOOKS, isTypingHooks);
    }

    public boolean isAutoAdditionList() {
        return getPreferences().getBoolean(AUTO_ADDITION_LIST, false);
    }

    public void setAutoAdditionList(boolean isAutoAdditionList) {
        getPreferences().putBoolean(AUTO_ADDITION_LIST, isAutoAdditionList);
    }

    public boolean isRemoveEmptyList() {
        return getPreferences().getBoolean(REMOVE_EMPTY_LIST, false);
    }

    public void setRemoveEmptyList(boolean isRemoveEmptyList) {
        getPreferences().putBoolean(REMOVE_EMPTY_LIST, isRemoveEmptyList);
    }

    public boolean isReorderOrderedListNumber() {
        return getPreferences().getBoolean(REORDER_ORDERED_LIST, false);
    }

    public void setReorderOrderedListNumber(boolean isReorder) {
        getPreferences().putBoolean(REORDER_ORDERED_LIST, isReorder);
    }

    public boolean isRemoveOrderedListNumber() {
        return getPreferences().getBoolean(REMOVE_ORDERED_LIST, false);
    }

    public void setRemoveOrderedListNumber(boolean isRemoveOrderedList) {
        getPreferences().putBoolean(REMOVE_ORDERED_LIST, isRemoveOrderedList);
    }

    public boolean isFXHtmlViewEnabled() {
        return getPreferences().getBoolean(FX_HTML_VIEW_ENABLED, true);
    }

    public void setFXHtmlViewEnabled(boolean fxHtmlViewEnabled) {
        getPreferences().putBoolean(FX_HTML_VIEW_ENABLED, fxHtmlViewEnabled);
    }

    public boolean isCustomPreviewRefreshIntervalUsed() {
      return getPreferences()
          .getBoolean(USE_CUSTOM_PREVIEW_REFRESH_INTERVAL, DEFAULT_USE_CUSTOM_PREVIEW_REFRESH_INTERVAL);
    }

    public void setUseCustomPreviewRefreshInterval(final boolean useCustomPreviewRefreshInterval) {
      getPreferences().putBoolean(USE_CUSTOM_PREVIEW_REFRESH_INTERVAL, useCustomPreviewRefreshInterval);
    }

    public int getCustomPreviewRefreshInterval() {
      return getPreferences()
          .getInt(CUSTOM_PREVIEW_REFRESH_INTERVAL, DEFAULT_PREVIEW_REFRESH_INTERVAL);
    }

    public int getPreviewRefreshIntervalInUse() {
      return isCustomPreviewRefreshIntervalUsed() ?
          getPreferences().getInt(CUSTOM_PREVIEW_REFRESH_INTERVAL, DEFAULT_PREVIEW_REFRESH_INTERVAL) :
          DEFAULT_PREVIEW_REFRESH_INTERVAL;
    }

    public void setCustomPreviewRefreshInterval(final int customPreviewRefreshInterval) {
      getPreferences().putInt(CUSTOM_PREVIEW_REFRESH_INTERVAL, customPreviewRefreshInterval);
    }

    private Preferences getPreferences() {
        return NbPreferences.forModule(MarkdownGlobalOptions.class);
    }
}
