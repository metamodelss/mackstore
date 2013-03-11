package com.mackstore.utils.misc;

import com.ckeditor.CKEditorConfig;

public class CKEditor_Config {
	public static CKEditorConfig configura(){
		CKEditorConfig configs = new CKEditorConfig();
		configs.addConfigValue("skin", "office2003");
		String toolbar = "[";
		toolbar+="[ 'Source','-','Bold','Italic','Underline','Strike','Subscript'," +
				"'Superscript','-','NumberedList','BulletedList'," +
				"'Outdent','Indent','-','JustifyLeft','JustifyCenter'," +
				"'JustifyRight','JustifyBlock' ]";
		toolbar+=",";
		toolbar+="[ 'TextColor','BGColor','-','Format','Font'," +
				"'FontSize' ]";
		toolbar+="]";
		configs.addConfigValue("toolbar",toolbar);
		configs.addConfigValue("width", "515");
		//configs.addConfigValue("uiColor", "#ADE82E");
		return configs;
	}
}
