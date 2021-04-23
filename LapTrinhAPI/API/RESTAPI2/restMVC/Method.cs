using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Net;
using System.IO;

namespace restMVC
{
    public static class Method
    {
        public static string GetJson(string FeedRequestUrl, string method)
        {
            HttpWebRequest feedRequest = (HttpWebRequest)WebRequest.Create(string.Concat("https://localhost:44384/api/", FeedRequestUrl));
            feedRequest.Method = method.ToUpper();
            feedRequest.Accept = "application/json";
            feedRequest.ContentType = "application/json; charset=utf-8";
            feedRequest.ContentLength = 0;

            WebResponse feedResponse = (HttpWebResponse)feedRequest.GetResponse();

            string data = "";

            using (feedResponse)
            {
                using (var reader = new StreamReader(feedResponse.GetResponseStream()))
                {
                    data = reader.ReadToEnd();
                }
            }
            return data;
        }
    }
}