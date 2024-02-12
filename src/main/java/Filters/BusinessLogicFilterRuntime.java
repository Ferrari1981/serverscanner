package Filters;

import businesslogic.AyntificationDontPasswordAndLogin;
import businesslogic.ListerAsyncContext;
import businesslogic.SubClassWriterErros;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;



@Named ("controllerFilterRuntime")
public class BusinessLogicFilterRuntime {

    @Inject
    private   SubClassWriterErros subClassWriterErros;
    @Inject
    private     AyntificationDontPasswordAndLogin ayntificationDontPasswordAndLogin;

    @Inject
    private ListerAsyncContext listerAsyncContext;


  protected     void startFilterRuntime(@NotNull  ServletRequest request,
                                        @NotNull ServletResponse response,
                                        @NotNull FilterChain chain,
                                        @NotNull ServletContext ЛОГ){
        try{
          ///  if(request.isSecure()) {
                HttpServletRequest asyrequest = (HttpServletRequest) request;
                HttpServletResponse asyresponse = (HttpServletResponse) response;
                asyrequest.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
                asyresponse.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
                asyresponse.setBufferSize(2048);/////buffer 163840
            // TODO: 11.01.2024 starting Async all Servers
               final AsyncContext asyncContext = asyrequest.startAsync();
            // TODO: 02.02.2024  слушатель
                listerAsyncContext.runnigAsyncContext(asyncContext,ЛОГ);

                // TODO: 10.03.2023  ТОЛЬКО ID DEVICE
                Object IDДевайсаКлиентаRuntime =
                        Optional.ofNullable((asyrequest).getHeaders("id_device_androis").nextElement()).orElse("");
                ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                        "  ЛогинОтAndroid    doFilter doFilter doFilter IDДевайсаКлиентаRuntime " + IDДевайсаКлиентаRuntime);

            completeFilterAuntification(chain, ЛОГ, asyncContext, IDДевайсаКлиентаRuntime);


            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                        " Success    doFilter doFilter doFilter IDДевайсаКлиентаRuntime " + IDДевайсаКлиентаRuntime +
                        " IDДевайсаКлиентаRuntime " + IDДевайсаКлиентаRuntime+ " request.isSecure() " +request.isSecure());


           // Module5Class module5Class=new Module5Class();

         ///   }
        ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n" );
    } catch (Exception e) {
        subClassWriterErros.
                МетодаЗаписиОшибкиВЛог(e,
                        Thread.currentThread().
                                getStackTrace(),
                        ЛОГ,"ErrorsLogs/ErrorJbossServletRuntime.txt");

    }
    }

    private void completeFilterAuntification(FilterChain chain, ServletContext ЛОГ,
                                             AsyncContext asyncContext,
                                             Object IDДевайсаКлиентаRuntime) throws IOException, ServletException {

      try{
          HttpServletRequest httpServletRequest=(HttpServletRequest) asyncContext.getRequest();
          HttpServletResponse httpServletResponse=(HttpServletResponse) asyncContext.getResponse();

      if (IDДевайсаКлиентаRuntime.toString().length() > 5) {

            // TODO: 11.03.2023 ГЛАВНАЯ СТРОЧКА ПЕРЕНАРАВЛЕНИЕ НА СЕВРЕЛТЫ НА ГЛАВНЫЙ КОД
            chain.doFilter(     httpServletRequest, httpServletResponse);

            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                    " Success    doFilter doFilter doFilter IDДевайсаКлиента " + IDДевайсаКлиентаRuntime);
        } else {
            // TODO: 11.03.2023  нет не имени не пароля
            ayntificationDontPasswordAndLogin.ayntificationDontPasswordAndLogin( httpServletRequest, httpServletResponse, ЛОГ);


            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                    " Success    doFilter doFilter doFilter IDДевайсаКлиента " + IDДевайсаКлиентаRuntime);

            // TODO: 11.03.2023  нет не имени не пароля
  /*      RequestDispatcher requestDispatcher = asyrequest.getRequestDispatcher("/indexfiltetuntime.jsp");
        requestDispatcher.forward(asyrequest, asyresponse);
        asyresponse.sendRedirect("/indexfiltetuntime.jsp");*/

        }

        ///   }
        ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+ " request.isSecure() " +httpServletRequest.isSecure());
    } catch (Exception e) {
        subClassWriterErros.
                МетодаЗаписиОшибкиВЛог(e,
                        Thread.currentThread().
                                getStackTrace(),
                        ЛОГ,"ErrorsLogs/ErrorJbossServletRuntime.txt");

    }
    }
}
