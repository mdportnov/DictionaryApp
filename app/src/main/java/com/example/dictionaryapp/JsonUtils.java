package com.example.dictionaryapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

class JsonUtils {
    private static JSONObject getJsonObject(String URL, String input) throws JSONException, ExecutionException, InterruptedException {
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute(URL, input);

        String jsonFile = asyncTask.get();

        return new JSONObject(jsonFile);
    }

    static Word getWordInfoFromJson(String URL, String input) throws JSONException {
        JSONObject obj = null;
        try {
            obj = getJsonObject(URL, input);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        Word word = new Word();
        try {
            if (obj.getJSONArray("entries").isNull(0)) {
                word.setWord(null);
                return word;
            } else {
                JSONArray lexemes = obj.getJSONArray("entries").getJSONObject(0).getJSONArray("lexemes");

                JSONArray senses = lexemes.getJSONObject(0).getJSONArray("senses");

//                if (lexemes.getJSONObject(0).optJSONArray("synonymSets") == null) {
//                    Log.d("pon", "no syn");
//                    word.setSynonyms(null);
//                } else {
//                    JSONArray synonymSets = lexemes.getJSONObject(0).getJSONArray("synonymSets");
//                    JSONArray synonyms = synonymSets.getJSONObject(0).getJSONArray("synonyms");
//                    ArrayList<String> synonymsList = new ArrayList<>();
//                    for (int i = 0; i < synonyms.length(); i++) {
//                        synonymsList.add(synonyms.getString(i));
//                    }
//                    word.setSynonyms(synonymsList);
//                }
//
//                if (lexemes.getJSONObject(0).optJSONArray("antonymSets") == null) {
//                    Log.d("pon", "no ant");
//
//                    word.setAntonyms(null);
//                } else {
//
//                    JSONArray antonymSets = lexemes.getJSONObject(0).getJSONArray("antonymSets");
//                    JSONArray antonyms = antonymSets.getJSONObject(0).getJSONArray("antonyms");
//
//                    ArrayList<String> antonymsList = new ArrayList<>();
//                    for (int i = 0; i < antonyms.length(); i++) {
//                        antonymsList.add(antonyms.getString(i));
//                    }
//                    word.setAntonyms(antonymsList);
//                }

                ArrayList<String> defintionsList = new ArrayList<>();

                for (int i = 0; i < senses.length(); i++) {
                    defintionsList.add(senses.getJSONObject(i).getString("definition"));
                }

                word.setWord(obj.getJSONArray("entries").getJSONObject(0).getString("entry"));
                word.setDefinitions(defintionsList);
            }
            return word;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return word;
    }
}

