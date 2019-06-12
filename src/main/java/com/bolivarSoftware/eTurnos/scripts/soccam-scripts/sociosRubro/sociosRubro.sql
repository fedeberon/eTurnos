USE [soccam]
GO

/****** Object:  Table [dbo].[sociosRubro]    Script Date: 12/06/2019 04:51:13 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[sociosRubro](
	[sociosRubro_id] [bigint] IDENTITY(1,1) NOT NULL,
	[sociosRubro_nombre] [nvarchar](150) NULL,
	[sociosRubro_deleted] [bit] NULL,
	[sociosRubro_modificado] [datetime] NULL,
 CONSTRAINT [PK_sociosRubro] PRIMARY KEY CLUSTERED 
(
	[sociosRubro_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


