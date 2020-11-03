package com.quasigroup.zio.akka.demo

 import sttp.tapir.server.akkahttp._
 import com.quasigroup.inc.basic.Entrance
 import com.quasigroup.zio.akka.classic
 import com.quasigroup.zio.akka.classic.http._
 import com.quasigroup.zio.akka.models.BindOn
 import zio._
 import zio.console._
 
 import scala.concurrent.{ExecutionContext, Future}
 
 object Main extends App {
 
 
   def run(args: List[String]) = (for {
       (name, binding) <- IO.succeed(("test", BindOn("127.0.0.1",8080))) // try using config to populate these
       routing <- IO.succeed[ToRoute](ec => Entrance.indexHtml.toRoute(_ => Future(Right("hello world"))(ec)))
       _ <- (for {
         akka <- classic.start(name)
         _ <- classic.http.start(binding,routing).provide(akka)
       } yield {}).use(_ => getStrLn)
   } yield {}).provideLayer(Console.live).run.exitCode
 
 }
