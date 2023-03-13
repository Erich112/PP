package ro.mike.tuiasi

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.File

/**
 * @param url - Uniform Resource Locator - address of an website
 * @return HTML content corresponding to the URL as a string
 */
fun testKhttpGetRequest(url: String) : String {
    val response = khttp.get(url)
    println("${response.statusCode}\t ${response.headers["Content-Type"]}")
    return response.text
}

/**
 * @param source - string specifying the source type (url, file, string)
 * @param url - string containing an URL, a path to a HTML file or an HTML string
 * @param baseURI - string used for the relative links inside of a local HTML file
 * @throws Exception - if the source is unknown
 */
class newsList(titlu: String, link: String){

}
fun testJsoup(source: String, url: String, baseURI: String?=null) {
    var htmlDocument: Document? = null
    htmlDocument = when(source) {
        "url" -> Jsoup.connect(url).get()
        "file" -> Jsoup.parse(File(url), "UTF-8", baseURI)
        "string" -> Jsoup.parse(url)
        else -> throw Exception("Unknown source")
    }
    var listaNews: MutableList<newsList>

    println(htmlDocument.title())
    val linkuri: String
    linkuri = htmlDocument.select("link").text()
    val listaLinkuri = linkuri.split(" ")
    for (link in listaLinkuri)
        println(link)
    var titluri: String
    titluri = htmlDocument.select("title").toString()
    val listaTitluri = titluri.split("\n")
    for (titlu in listaTitluri) {
        var tit : String
        tit= titlu.replace("<title>","")
        tit = tit.replace("</title>","")
        tit= titlu.replace("<title><![CDATA[","")
        tit = tit.replace("]]></title>","")
        println(tit)
    }
}

fun main() {
    val url:String = "http://rss.cnn.com/rss/edition.rss"
    val htmlContent: String = testKhttpGetRequest(url)
    println("*".repeat(100))

    testJsoup("url", url)
    println("*".repeat(100))
}