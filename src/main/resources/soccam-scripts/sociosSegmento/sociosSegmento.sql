USE [soccam]
GO

/****** Object:  Table [dbo].[sociosSegmento]    Script Date: 12/06/2019 04:53:01 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[sociosSegmento](
	[sociosSegmento_id] [bigint] IDENTITY(1,1) NOT NULL,
	[sociosSegmento_rubro] [bigint] NULL,
	[sociosSegmento_nombre] [nvarchar](150) NULL,
	[sociosSegmento_deleted] [bit] NULL,
	[sociosSegmento_modificado] [datetime] NULL,
 CONSTRAINT [PK_sociosSegmento] PRIMARY KEY CLUSTERED 
(
	[sociosSegmento_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


