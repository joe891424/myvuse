package com.qualtrics.digital;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackAccessibilityConstants {
    static Map<String, String> THUMBS_UP_LANGUAGES = createThumbsUpMap();
    static final Map<String, String> THUMBS_DOWN_LANGUAGES = createThumbsDownMap();
    static final Map<String, String> CLOSE_LANGUAGES = createCloseMap();
    static final Map<String, String> NeitherHelpfulNorUnhelpful_LANGUAGES = createNeitherHelpfulNorUnhelpfulMap();
    static final Map<String, String> ExtremelyUnhelpful_LANGUAGES = createExtremelyUnhelpfulMap();
    static final Map<String, String> SomewhatUnhelpful_LANGUAGES = createSomeWhatUnHelpfulMap();
    static final Map<String, String> SomewhatHelpful_LANGUAGES = createSomewhatHelpfulMap();
    static final Map<String, String> ExtremelyHelpful_LANGUAGES = createExtremelyHelpfulMap();

    EmbeddedFeedbackAccessibilityConstants() {
    }

    static Map<String, String> createThumbsUpMap() {
        HashMap map = new HashMap();
        map.put("DE", "Zustimmen");
        map.put("SV", "Tummen upp");
        map.put("RU", "Нравится");
        map.put("FI", "Peukalo ylös");
        map.put("PT", "Polegar para cima");
        map.put("KO", "승인");
        map.put("PT-BR", "Curto");
        map.put("EN", "Thumbs Up");
        map.put("IT", "Benissimo");
        map.put("FR", "Pouce vers le haut");
        map.put("RI-GI", "\u206a\u206a\u206a\u200c\u200b\u200c\u200d\u200d\u200c\u200c\u200d\u200b\u200d\u200b\u200b\u200b\u200c\u200d\u200b\u200d\u200b\u200b\u200d\u200c\u200c\u200b\u200b\u200c\u200d\u200d\u200c\u200c\u200d\u200b\u200d\u200b\u200c\u200d\u200d\u200d\u200b\u200c\u200d\u200c\u206aThumbs Up\u206a\u206a");
        map.put("ES-ES", "Conforme");
        map.put("ZH-HANS", "赞");
        map.put("ZH-HANT", "喜歡");
        map.put("PB", "⟦용용용 Ŧнųmьś Ŭρ 歴歴歴⟧");
        map.put("TH", "ชอบ");
        map.put("JA", "賛成");
        map.put("DA", "Tommelfingeren op");
        map.put("EN-GB", "Thumbs Up");
        map.put("NL", "Duim omhoog");
        map.put("ES-419", "Pulgar arriba");
        map.put("EN-US", "Thumbs Up");
        return map;
    }

    static Map<String, String> createThumbsDownMap() {
        HashMap map = new HashMap();
        map.put("DE", "Ablehnen");
        map.put("SV", "Tummen ned");
        map.put("RU", "Не нравится");
        map.put("FI", "Peukalo alas");
        map.put("PT", "Polegar para baixo");
        map.put("KO", "거절");
        map.put("PT-BR", "Não curto");
        map.put("EN", "Thumbs Down");
        map.put("IT", "Malissimo");
        map.put("FR", "Pouce vers le bas");
        map.put("RI-GI", "\u206a\u206a\u206a\u200c\u200b\u200c\u200b\u200b\u200d\u200c\u200c\u200c\u200b\u200c\u200d\u200d\u200d\u200c\u200c\u200d\u200d\u200d\u200d\u200c\u200c\u200d\u200d\u200c\u200c\u200d\u200d\u200c\u200d\u200d\u200c\u200c\u200b\u200b\u200d\u200d\u200d\u200d\u200d\u200c\u206aThumbs Down\u206a\u206a");
        map.put("ES-ES", "No conforme");
        map.put("ZH-HANS", "很逊");
        map.put("ZH-HANT", "不喜歡");
        map.put("PB", "⟦용용용 Τнцmвŝ Ðοωń 歴歴歴⟧");
        map.put("TH", "ไม่ชอบ");
        map.put("JA", "不賛成");
        map.put("DA", "Tommelfingeren ned");
        map.put("EN-GB", "Thumbs Down");
        map.put("NL", "Duim omlaag");
        map.put("ES-419", "Pulgar abajo");
        map.put("EN-US", "Thumbs Down");
        return map;
    }

    static Map<String, String> createCloseMap() {
        HashMap map = new HashMap();
        map.put("DE", "Schließen");
        map.put("EN", "Close");
        map.put("EN-GB", "Close");
        map.put("EN-US", "Close");
        map.put("ES-ES", "Cerrar");
        map.put("ES-419", "Cerrar");
        map.put("FI", "Sulje");
        map.put("FR", "Fermer");
        map.put("IT", "Chiudi");
        map.put("JA", "閉じます");
        map.put("KO", "닫힙니다");
        map.put("NL", "Sluiten");
        map.put("PB", "⟦용용용용 Čĺőŝе");
        map.put("PT", "Fechar");
        map.put("PT-BR", "Feche");
        map.put("ZH-HANS", "关闭");
        map.put("ZH-HANT", "關閉");
        return map;
    }

    static Map<String, String> createNeitherHelpfulNorUnhelpfulMap() {
        HashMap map = new HashMap();
        map.put("DE", "Weder hilfsbereit noch nicht hilfsbereit");
        map.put("SV", "Varken eller");
        map.put("RU", "Трудно сказать); полезен или бесполезен");
        map.put("FI", "Ei hyödyllinen eikä hyödytön");
        map.put("PT", "Nem útil nem inútil");
        map.put("KO", "도움이 되지도 안 되지도 않음");
        map.put("PT-BR", "Nem útil nem inútil");
        map.put("EN", "Neither helpful nor unhelpful");
        map.put("IT", "Né utile né inutile");
        map.put("FR", "Ni utile, ni inutile");
        map.put("RI-GI", "\u206a\u206a\u206a\u200c\u200c\u200b\u200b\u200b\u200c\u200b\u200b\u200c\u200b\u200d\u200d\u200c\u200c\u200c\u200c\u200b\u200c\u200d\u200d\u200c\u200c\u200c\u200d\u200c\u200d\u200b\u200b\u200c\u200c\u200c\u200c\u200b\u200c\u200d\u200b\u200d\u200b\u200c\u200c\u206aNeither helpful nor unhelpful\u206a\u206a");
        map.put("ES-ES", "Ni útil ni inútil");
        map.put("ZH-HANS", "无所谓有没有帮助");
        map.put("ZH-HANT", "無所謂有幫助或無幫助");
        map.put("PB", "⟦용용용용용 Иєíťнěŗ нéľρƒűļ ŉοг üņħēĺρƒųĺ 歴歴歴歴歴⟧");
        map.put("TH", "เฉยๆ");
        map.put("JA", "どちらでもない");
        map.put("DA", "Hverken hjælpsom eller uhjælpsom");
        map.put("EN-GB", "Neither helpful nor unhelpful");
        map.put("NL", "Niet behulpzaam, niet onbehulpzaam");
        map.put("ES-419", "Ni útil ni poco útil");
        map.put("EN-US", "Neither helpful nor unhelpful");
        return map;
    }

    static Map<String, String> createExtremelyUnhelpfulMap() {
        HashMap map = new HashMap();
        map.put("DE", "Überhaupt nicht hilfsbereit");
        map.put("SV", "Inte alls hjälpsam");
        map.put("RU", "Совсем бесполезен");
        map.put("FI", "Todella hyödytön");
        map.put("PT", "Extremamente inútil");
        map.put("KO", "매우 도움이 되지 않음");
        map.put("PT-BR", "Extremamente inútil");
        map.put("EN", "Extremely unhelpful");
        map.put("IT", "Estremamente inutile");
        map.put("FR", "Extrêmement inutile");
        map.put("RI-GI", "\u206a\u206a\u206a\u200d\u200c\u200b\u200d\u200d\u200b\u200d\u200c\u200b\u200b\u200b\u200b\u200d\u200d\u200c\u200c\u200d\u200b\u200d\u200c\u200c\u200c\u200d\u200d\u200b\u200c\u200b\u200b\u200d\u200d\u200c\u200b\u200b\u200c\u200b\u200d\u200b\u200c\u200b\u206aExtremely unhelpful\u206a\u206a");
        map.put("ES-ES", "Extremadamente inútil");
        map.put("ZH-HANS", "毫无帮助");
        map.put("ZH-HANT", "毫無幫助");
        map.put("PB", "⟦용용용용용 Ē×τґέmєĺỳ űŋħėĺρƒüĺ 歴歴歴歴歴⟧");
        map.put("TH", "ช่วยไม่ได้อย่างยิ่ง");
        map.put("JA", "まったく役立っていない");
        map.put("DA", "Meget uhjælpsom");
        map.put("EN-GB", "Extremely unhelpful");
        map.put("NL", "Buitengewoon onbehulpzaam");
        map.put("ES-419", "Extremadamente poco útil");
        map.put("EN-US", "Extremely unhelpful");
        return map;
    }

    static Map<String, String> createSomeWhatUnHelpfulMap() {
        HashMap map = new HashMap();
        map.put("DE", "Eher nicht hilfsbereit");
        map.put("SV", "Ganska hjälpsam");
        map.put("RU", "Скорее бесполезен");
        map.put("FI", "Jonkin verran hyödytön");
        map.put("PT", "Parcialmente inútil");
        map.put("KO", "어느 정도 도움이 되지 않음");
        map.put("PT-BR", "Mais ou menos inútil");
        map.put("EN", "Somewhat unhelpful");
        map.put("IT", "Abbastanza inutile");
        map.put("FR", "Plutôt inutile");
        map.put("RI-GI", "\u206a\u206a\u206a\u200d\u200c\u200c\u200b\u200c\u200b\u200d\u200b\u200b\u200d\u200d\u200b\u200c\u200c\u200c\u200b\u200c\u200d\u200b\u200c\u200c\u200c\u200b\u200c\u200c\u200b\u200c\u200d\u200c\u200d\u200c\u200b\u200b\u200b\u200b\u200d\u200c\u200d\u200d\u206aSomewhat unhelpful\u206a\u206a");
        map.put("ES-ES", "Algo inútil");
        map.put("ZH-HANS", "有点没用");
        map.put("ZH-HANT", "不算有幫助");
        map.put("PB", "⟦용용용용용 Śοmęẃнąţ ŭήнêľρƒμľ 歴歴歴歴歴⟧");
        map.put("TH", "ค่อนข้างช่วยไม่ได้");
        map.put("JA", "どちらかといえば役立っていない");
        map.put("DA", "Nogenlunde uhjælpsom");
        map.put("EN-GB", "Somewhat unhelpful");
        map.put("NL", "Enigszins onbehulpzaam");
        map.put("ES-419", "Poco útil");
        map.put("EN-US", "Somewhat unhelpful");
        return map;
    }

    static Map<String, String> createSomewhatHelpfulMap() {
        HashMap map = new HashMap();
        map.put("DE", "Eher hilfsbereit");
        map.put("SV", "Ganska hjälpsam");
        map.put("RU", "Скорее полезен");
        map.put("FI", "Jonkin verran hyödyllinen");
        map.put("PT", "Parcialmente útil");
        map.put("KO", "어느 정도 도움이 됨");
        map.put("PT-BR", "Mais ou menos útil");
        map.put("EN", "Somewhat helpful");
        map.put("IT", "Abbastanza utile");
        map.put("FR", "Assez utile");
        map.put("RI-GI", "\u206a\u206a\u206a\u200c\u200c\u200c\u200b\u200c\u200d\u200b\u200b\u200d\u200c\u200c\u200c\u200b\u200d\u200d\u200b\u200c\u200b\u200d\u200c\u200b\u200b\u200c\u200d\u200b\u200c\u200c\u200b\u200d\u200c\u200c\u200c\u200d\u200c\u200b\u200c\u200c\u200d\u200d\u200d\u200c\u206aSomewhat helpful\u206a\u206a");
        map.put("ES-ES", "Algo útil");
        map.put("ZH-HANS", "有点帮助");
        map.put("ZH-HANT", "還算有幫助");
        map.put("PB", "⟦용용용용 Ŝômέẁħäŧ ħēļρƒůĺ 歴歴歴歴⟧");
        map.put("TH", "ค่อนข้างช่วยได้");
        map.put("JA", "いくらか役立っている");
        map.put("DA", "Nogenlunde hjælpsom");
        map.put("EN-GB", "Somewhat helpful");
        map.put("NL", "Enigszins behulpzaam");
        map.put("ES-419", "Algo útil");
        map.put("EN-US", "Somewhat helpful");
        return map;
    }

    static Map<String, String> createExtremelyHelpfulMap() {
        HashMap map = new HashMap();
        map.put("DE", "Äußerst hilfsbereit");
        map.put("SV", "Mycket hjälpsam");
        map.put("RU", "Очень полезен");
        map.put("FI", "Todella hyödyllinen");
        map.put("PT", "Extremamente útil");
        map.put("KO", "매우 도움이 됨");
        map.put("PT-BR", "Extremamente útil");
        map.put("EN", "Extremely helpful");
        map.put("IT", "Estremamente utile");
        map.put("FR", "Extrêmement utile");
        map.put("RI-GI", "\u206a\u206a\u206a\u200d\u200c\u200b\u200d\u200d\u200c\u200c\u200d\u200d\u200d\u200b\u200b\u200d\u200b\u200b\u200c\u200d\u200d\u200d\u200d\u200c\u200b\u200b\u200c\u200c\u200d\u200c\u200c\u200d\u200c\u200b\u200b\u200d\u200b\u200d\u200c\u200d\u200b\u200c\u200d\u206aExtremely helpful\u206a\u206a");
        map.put("ES-ES", "Extremadamente útil");
        map.put("ZH-HANS", "非常有帮助");
        map.put("ZH-HANT", "極有幫助");
        map.put("PB", "⟦용용용용용 Σхτгëmєļÿ ĥěĺρƒůĺ 歴歴歴歴歴⟧");
        map.put("TH", "ช่วยได้อย่างยิ่ง");
        map.put("JA", "非常に役立っている");
        map.put("DA", "Meget hjælpsom");
        map.put("EN-GB", "Extremely helpful");
        map.put("NL", "Buitengewoon behulpzaam");
        map.put("ES-419", "Extremadamente útil");
        map.put("EN-US", "Extremely helpful");
        return map;
    }
}
